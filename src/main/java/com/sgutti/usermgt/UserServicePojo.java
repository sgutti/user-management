/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import javax.persistence.PersistenceException;

import org.dozer.Mapper;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sgutti.core.base.BaseServicePojo;
import com.sgutti.core.exception.ApplicationException;
import com.sgutti.usermgt.constants.ServiceConstants;
import com.sgutti.usermgt.dao.PermissionDAO;
import com.sgutti.usermgt.dao.RoleDAO;
import com.sgutti.usermgt.dao.RolePermissionsDAO;
import com.sgutti.usermgt.dao.UserDAO;
import com.sgutti.usermgt.dao.UserRolesDAO;
import com.sgutti.usermgt.data.PermissionData;
import com.sgutti.usermgt.data.RoleData;
import com.sgutti.usermgt.data.UserData;
import com.sgutti.usermgt.entities.Permission;
import com.sgutti.usermgt.entities.Role;
import com.sgutti.usermgt.entities.RolePermissions;
import com.sgutti.usermgt.entities.User;
import com.sgutti.usermgt.entities.UserRoles;
import com.sgutti.usermgt.specs.UserSpecs;

/**
 * @author Shanmu
 * @date Jul 7, 2014 7:19:19 PM
 */
@Service(ServiceConstants.USER_SERVICE)
public class UserServicePojo extends BaseServicePojo implements UserService {
    private static final String USER_SVC_0004 = "USER_SVC_0004";

    private static final String UNABLE_TO_DELETE_USER = "unable to delete user";

    private static final String USER_SVC_0005 = "USER_SVC_0005";

    private static final String USER_DATA_CANNOT_BE_NULL = "userData cannot be null";

    private static final String USER_SVC_NULL_PARAM = "USER_SVC_NULL_PARAM";

    // --------------------------------------------------------------- Constants
    private static final String USER_NOT_FOUND = "user not found";

    private static final String USER_SVC_USER_NOT_FOUND = "USER_SVC_USER_NOT_FOUND";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleDAO roleDAO;

    @Autowired
    private PermissionDAO permissionDAO;

    @Autowired
    private UserRolesDAO userRolesDAO;

    @Autowired
    private RolePermissionsDAO rolePermissionsDAO;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>UserServicePojo</code>
     */
    public UserServicePojo() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @see com.sgutti.usermgt.UserService#retrieveRole(long, long)
     */
    @Override
    @Transactional
    public RoleData retrieveRole(final long tenantID, final long roleID)
            throws ApplicationException {
        RoleData roleData = null;
        try {
            Mapper mapper = getMapper();
            Role role = roleDAO.findByRoleID(tenantID, roleID);
            if (role == null) {
                throw new ApplicationException("ERR_USER_SVC_001",
                        "Role NOT found");
            }
            roleData = mapper.map(role, RoleData.class);
            Collection<Permission> permissionList = role.getPermissions();
            if (permissionList != null) {
                List<PermissionData> permissions = new ArrayList<>();
                for (Permission permission : permissionList) {
                    PermissionData permissionData = mapper.map(permission,
                            PermissionData.class);
                    permissions.add(permissionData);
                }
                roleData.setPermissions(permissions);
            }
        } catch (PersistenceException pe) {
            throw new ApplicationException("ERR_USER_SVC_004",
                    pe.getLocalizedMessage(), pe);
        }
        return roleData;
    }

    /**
     * @see com.sgutti.usermgt.UserService#retrieveAllPermissions()
     */
    @Override
    @Transactional
    public List<PermissionData> retrieveAllPermissions()
            throws ApplicationException {
        List<PermissionData> permissionsList = null;
        Iterable<Permission> permissions = permissionDAO
                .findByType(Permission.SYSTEM);
        if (permissions != null) {
            Mapper mapper = getMapper();
            permissionsList = new ArrayList<>();
            for (Permission permission : permissions) {
                PermissionData permissionData = mapper.map(permission,
                        PermissionData.class);
                permissionsList.add(permissionData);
            }
        }
        return permissionsList;
    }

    /**
     * @see com.sgutti.usermgt.UserService#retrieveAllUsers(long,
     *      java.lang.String, java.lang.String, boolean)
     */
    @Override
    @Transactional
    public List<UserData> retrieveAllUsers(final long tenantID,
                                           final String firstName,
                                           final String lastName,
                                           final boolean exactMatch)
            throws ApplicationException {
        List<UserData> result = null;
        try {
            List<User> usersList = userDAO.findAll(UserSpecs.getWhere(tenantID,
                    firstName, lastName, exactMatch));
            result = new ArrayList<>();
            if (usersList != null) {
                Mapper mapper = getMapper();
                for (User user : usersList) {
                    UserData temp = mapper.map(user, UserData.class);
                    result.add(temp);
                }
            }
        } catch (PersistenceException pe) {
            throw new ApplicationException("USER_SVC_0001",
                    "unable to retrieve users", pe);
        }
        return result;
    }

    /**
     * @see com.sgutti.usermgt.UserService#retrieveAllRoles(long,
     *      java.lang.String, boolean)
     */
    @Override
    @Transactional
    public List<RoleData> retrieveAllRoles(final long tenantID,
                                           final String roleName,
                                           final boolean exactMatch)
            throws ApplicationException {
        List<RoleData> result = null;
        try {
            List<Role> rolesList = roleDAO.findAll();
            result = new ArrayList<>();
            if (rolesList != null) {
                Mapper mapper = getMapper();
                for (Role role : rolesList) {
                    RoleData temp = mapper.map(role, RoleData.class);
                    result.add(temp);
                }
            }
        } catch (PersistenceException pe) {
            throw new ApplicationException("USER_SVC_0002",
                    "unable to retrieve roles", pe);
        }
        return result;
    }

    /**
     * @see com.sgutti.usermgt.UserService#createUser(long,
     *      com.sgutti.usermgt.data.UserData)
     */
    @Override
    @Transactional
    public boolean createUser(final long tenantID, final String createdBy,
                              final UserData userData)
            throws ApplicationException {
        boolean result = false;
        if (userData == null) {
            throw new ApplicationException(USER_SVC_NULL_PARAM,
                    USER_DATA_CANNOT_BE_NULL);
        }
        try {
            Mapper mapper = getMapper();
            User user = mapper.map(userData, User.class);
            user.setTenantID(tenantID);
            user.setCreatedBy(createdBy);
            user.setCreatedDate(Calendar.getInstance().getTime());
            userDAO.save(user);
            long roleID = userData.getRoleID();
            UserRoles userRoles = new UserRoles();
            userRoles.setUserID(user.getUserID());
            userRoles.setRoleID(roleID);
            userRolesDAO.save(userRoles);
            result = true;
        } catch (PersistenceException pe) {
            throw new ApplicationException("USER_SVC_0003",
                    "unable to create user", pe);
        }
        return result;
    }

    /**
     * @param tenantID
     * @param modifiedBy
     * @return
     */
    @Override
    @Transactional
    public boolean updateUser(final long tenantID, final String modifiedBy,
                              final UserData userData)
            throws ApplicationException {
        boolean result = false;
        if (userData == null) {
            throw new ApplicationException(USER_SVC_NULL_PARAM,
                    USER_DATA_CANNOT_BE_NULL);
        }
        try {
            User user = userDAO.findBy(tenantID, userData.getUserID());
            if (user == null) {
                throw new ApplicationException(USER_SVC_USER_NOT_FOUND,
                        USER_NOT_FOUND);
            }
            userRolesDAO.deleteAll(user.getUserID());
            Mapper mapper = getMapper();
            mapper.map(userData, user);
            user.setModifiedBy(modifiedBy);
            user.setModifiedDate(Calendar.getInstance().getTime());
            if (user.getRoles() != null) {
                user.setRoles(null);
            }
            userDAO.save(user);
            long roleID = userData.getRoleID();
            UserRoles userRoles = new UserRoles();
            userRoles.setUserID(user.getUserID());
            userRoles.setRoleID(roleID);
            userRolesDAO.save(userRoles);
            // user.setRoles(Arrays.asList(role));
            userDAO.save(user);
            result = true;
        } catch (PersistenceException pe) {
            throw new ApplicationException(USER_SVC_0004,
                    "unable to update user", pe);
        }
        return result;
    }

    /**
     * @see com.sgutti.usermgt.UserService#deleteUser(long, java.lang.String)
     */
    @Override
    @Transactional
    public boolean deleteUser(final long tenantID, final String userID)
            throws ApplicationException {
        boolean result = false;
        try {
            userDAO.deleteBy(tenantID, userID);
            result = true;
        } catch (PersistenceException pe) {
            throw new ApplicationException(USER_SVC_0005,
                    UNABLE_TO_DELETE_USER, pe);
        }
        return result;
    }

    /**
     * @see com.sgutti.usermgt.UserService#changePassword(long,
     *      java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public boolean changePassword(final long tenantID, final String userID,
                                  final String password)
            throws ApplicationException {
        boolean result = false;
        try {
            User user = userDAO.findBy(tenantID, userID);
            if (user == null) {
                throw new ApplicationException(USER_SVC_USER_NOT_FOUND,
                        USER_NOT_FOUND);
            }
            user.setPassword(password);
            userDAO.save(user);
            result = true;
        } catch (PersistenceException pe) {
            throw new ApplicationException("USER_SVC_0006",
                    "unable to change password", pe);
        }
        return result;
    }

    /**
     * @see com.sgutti.usermgt.UserService#retrieveUser(long, java.lang.String)
     */
    @Override
    @Transactional
    public UserData retrieveUser(final long tenantID, final String userID)
            throws ApplicationException {
        UserData result = null;
        try {
            User user = userDAO.findBy(tenantID, userID);
            if (user == null) {
                throw new ApplicationException(USER_SVC_USER_NOT_FOUND,
                        USER_NOT_FOUND);
            }
            Mapper mapper = getMapper();
            result = mapper.map(user, UserData.class);
            Collection<Role> roles = user.getRoles();
            if (roles != null) {
                StringBuilder str = new StringBuilder();
                for (Role role : roles) {
                    str.append(role.getName());
                    result.setRoleID(role.getRoleID());
                }
                result.setRole(str.toString());
            }
        } catch (PersistenceException pe) {
            throw new ApplicationException("USER_SVC_0007",
                    "unable to retrieve user", pe);
        }
        return result;
    }

    /**
     * @see com.sgutti.usermgt.UserService#createRole(long,
     *      com.sgutti.usermgt.data.RoleData)
     */
    @Override
    @Transactional
    public boolean createRole(final long tenantID, final String createdBy,
                              final RoleData roleData)
            throws ApplicationException {
        boolean result = false;
        if (roleData == null) {
            throw new ApplicationException(USER_SVC_NULL_PARAM,
                    "roleData cannot be null");
        }
        try {
            DateTime currentDate = new DateTime();
            Mapper mapper = getMapper();
            Role role = mapper.map(roleData, Role.class);
            List<Permission> permissions = permissionDAO
                    .findBy(roleData.getPermissionIDs());
            role.setTenantID(tenantID);
            role.setCreatedBy(createdBy);
            role.setCreatedDate(currentDate.toDate());
            roleDAO.save(role);
            List<RolePermissions> rolePermissions = new ArrayList<>();
            for (Permission permission : permissions) {
                RolePermissions rPerm = new RolePermissions();
                rPerm.setRoleID(role.getRoleID());
                rPerm.setPermissionID(permission.getPermissionID());
                rolePermissions.add(rPerm);
            }
            rolePermissionsDAO.saveAll(rolePermissions);
            result = true;
        } catch (PersistenceException pe) {
            throw new ApplicationException("USER_SVC_0008",
                    "unable to create role", pe);
        }
        return result;
    }

    /**
     * @see com.sgutti.usermgt.UserService#updateRole(long, java.lang.String,
     *      com.sgutti.usermgt.data.RoleData)
     */
    @Override
    @Transactional
    public boolean updateRole(final long tenantID, final String modifiedBy,
                              final RoleData roleData)
            throws ApplicationException {
        boolean result = false;
        if (roleData == null) {
            throw new ApplicationException(USER_SVC_NULL_PARAM,
                    "roleData cannot be null");
        }
        try {
            // first delete the associated permissions to the role
            // Save the role
            Role role = roleDAO.findByRoleID(tenantID, roleData.getRoleID());
            DateTime currentDate = new DateTime();
            Mapper mapper = getMapper();
            mapper.map(roleData, role);
            role.setModifiedBy(modifiedBy);
            role.setModifiedDate(currentDate.toDate());
            if (role.getPermissions() != null) {
                role.setPermissions(null);
            }
            roleDAO.save(role);
            // Get all the selected permissions
            List<Permission> permissions = permissionDAO
                    .findBy(roleData.getPermissionIDs());
            List<RolePermissions> rolePermissions = new ArrayList<>();
            for (Permission permission : permissions) {
                RolePermissions rPerm = new RolePermissions();
                rPerm.setRoleID(role.getRoleID());
                rPerm.setPermissionID(permission.getPermissionID());
                rolePermissions.add(rPerm);
            }
            rolePermissionsDAO.saveAll(rolePermissions);
            role.setPermissions(permissions);
            roleDAO.save(role);
            result = true;
        } catch (PersistenceException pe) {
            throw new ApplicationException("USER_SVC_0009",
                    "unable to update role", pe);
        }
        return result;
    }

    /**
     * @see com.sgutti.usermgt.UserService#retrieveAllRoles(long)
     */
    @Override
    @Transactional
    public List<RoleData> retrieveAllRoles(final long tenantID)
            throws ApplicationException {
        List<RoleData> result = null;
        try {
            List<Role> rolesList = roleDAO.findBy(tenantID);
            result = new ArrayList<>();
            if (rolesList != null) {
                Mapper mapper = getMapper();
                for (Role role : rolesList) {
                    RoleData temp = mapper.map(role, RoleData.class);
                    result.add(temp);
                }
            }
        } catch (PersistenceException pe) {
            throw new ApplicationException("USER_SVC_0010",
                    "unable to retrieve roles", pe);
        }
        return result;
    }

    /**
     * @return Returns the userDAO.
     */
    public UserDAO getUserDAO() {
        return userDAO;
    }

    /**
     * @param userDAO
     *            The userDAO to set.
     */
    public void setUserDAO(final UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * @return Returns the roleDAO.
     */
    public RoleDAO getRoleDAO() {
        return roleDAO;
    }

    /**
     * @param roleDAO
     *            The roleDAO to set.
     */
    public void setRoleDAO(final RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    /**
     * @return Returns the permissionDAO.
     */
    public PermissionDAO getPermissionDAO() {
        return permissionDAO;
    }

    /**
     * @param permissionDAO
     *            The permissionDAO to set.
     */
    public void setPermissionDAO(final PermissionDAO permissionDAO) {
        this.permissionDAO = permissionDAO;
    }

    /**
     * @return Returns the rolePermissionsDAO.
     */
    public RolePermissionsDAO getRolePermissionsDAO() {
        return rolePermissionsDAO;
    }

    /**
     * @param rolePermissionsDAO
     *            The rolePermissionsDAO to set.
     */
    public void setRolePermissionsDAO(final RolePermissionsDAO rolePermissionsDAO) {
        this.rolePermissionsDAO = rolePermissionsDAO;
    }

    /**
     * @return Returns the userRolesDAO.
     */
    public UserRolesDAO getUserRolesDAO() {
        return userRolesDAO;
    }

    /**
     * @param userRolesDAO
     *            The userRolesDAO to set.
     */
    public void setUserRolesDAO(final UserRolesDAO userRolesDAO) {
        this.userRolesDAO = userRolesDAO;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
