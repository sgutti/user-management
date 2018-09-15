/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sgutti.usermgt.entities.RolePermissions;
import com.sgutti.usermgt.entities.RolePermissionsPK;
import com.sgutti.usermgt.entities.UserRoles;

/**
 * @author Shanmu
 * @date Jul 21, 2014 6:56:44 PM
 */
public interface RolePermissionsDAO
        extends JpaRepository<RolePermissions, RolePermissionsPK> {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param roleID
     * @return
     */
    @Query(" from RolePermissions ur where  ur.roleID=?1")
    public List<UserRoles> findByRoleID(Long roleID);

    /**
     * @param roleID
     */
    @Modifying
    @Query("delete from RolePermissions ur where ur.roleID=?1")
    public void deleteAll(Long roleID);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
