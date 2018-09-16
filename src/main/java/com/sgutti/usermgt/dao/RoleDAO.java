/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgutti.usermgt.entities.Role;

/**
 * @author Shanmu
 * @date Jul 7, 2014 7:06:13 PM
 */
public interface RoleDAO extends JpaRepository<Role, Long> {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param corpID
     * @param roleNameLike
     * @return
     */
    @Query(" from Role r where r.tenantID=?1 and r.roleID= ?2")
    Role findByRoleID(long tenantID, long roleID);

    /**
     * @param tenantID
     * @return
     */
    @Query(" from Role r where r.tenantID=?1")
    List<Role> findBy(long tenantID);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
