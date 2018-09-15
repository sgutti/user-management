/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sgutti.usermgt.entities.UserRolePK;
import com.sgutti.usermgt.entities.UserRoles;

/**
 * @author Shanmu
 * @date Jul 21, 2014 6:40:34 PM
 */
public interface UserRolesDAO extends JpaRepository<UserRoles, UserRolePK> {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param userID
     * @return
     */
    @Query(" from UserRoles ur where ur.userID=?1")
    public UserRoles findByUserID(String userID);

    /**
     * @param userID
     */
    @Modifying
    @Query("delete from UserRoles ur where ur.userID=?1")
    public void deleteAll(String userID);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
