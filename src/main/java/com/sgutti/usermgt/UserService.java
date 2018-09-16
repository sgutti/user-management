/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt;

import java.util.List;

import com.sgutti.core.base.BaseService;
import com.sgutti.core.exception.ApplicationException;
import com.sgutti.usermgt.data.PermissionData;
import com.sgutti.usermgt.data.RoleData;
import com.sgutti.usermgt.data.UserData;

/**
 * @author Shanmu
 * @date Jul 7, 2014 7:02:47 PM
 */
public interface UserService extends BaseService {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param tenantID
     * @param createdBy
     * @param userData
     * @return
     * @throws ApplicationException
     */
    boolean createUser(long tenantID, String createdBy, UserData userData)
            throws ApplicationException;

    /**
     * @param tenantID
     * @param modifiedBy
     * @param userData
     * @return
     * @throws ApplicationException
     */
    boolean updateUser(long tenantID, String modifiedBy, UserData userData)
            throws ApplicationException;

    /**
     * @param tenantID
     * @param userID
     * @return
     * @throws ApplicationException
     */
    boolean deleteUser(long tenantID, String userID)
            throws ApplicationException;

    /**
     * @param tenantID
     * @param userID
     * @return
     * @throws ApplicationException
     */
    UserData retrieveUser(long tenantID, String userID)
            throws ApplicationException;

    /**
     * @param tenantID
     * @param userID
     * @param password
     * @return
     * @throws ApplicationException
     */
    boolean changePassword(long tenantID, String userID, String password)
            throws ApplicationException;

    /**
     * @param tenantID
     * @return
     * @throws ApplicationException
     */
    List<UserData> retrieveAllUsers(long tenantID, String firstName,
                                    String lastName, boolean exactMatch)
            throws ApplicationException;

    /**
     * @param tenantID
     * @param roleName
     * @param exactMatch
     * @return
     * @throws ApplicationException
     */
    List<RoleData> retrieveAllRoles(long tenantID, String roleName,
                                    boolean exactMatch)
            throws ApplicationException;

    /**
     * @param tenantID
     * @return
     * @throws ApplicationException
     */
    List<RoleData> retrieveAllRoles(long tenantID) throws ApplicationException;

    /**
     * @return
     * @throws ApplicationException
     */
    List<PermissionData> retrieveAllPermissions() throws ApplicationException;

    /**
     * @param tenantID
     * @param roleID
     * @return
     * @throws ApplicationException
     */
    RoleData retrieveRole(final long tenantID, final long roleID)
            throws ApplicationException;

    /**
     * @param tenantID
     * @param createdBy
     * @param roleData
     * @return
     * @throws ApplicationException
     */
    boolean createRole(long tenantID, String createdBy, RoleData roleData)
            throws ApplicationException;

    /**
     * @param tenantID
     * @param modifiedBy
     * @param roleData
     * @return
     * @throws ApplicationException
     */
    boolean updateRole(long tenantID, String modifiedBy, RoleData roleData)
            throws ApplicationException;
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
