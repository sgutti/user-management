/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sgutti.usermgt.entities.User;

/**
 * @author Shanmu
 * @date Jul 7, 2014 7:05:23 PM
 */
public interface UserDAO
        extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
    // --------------------------------------------------------------- Constants
    String NAME = "userDAO";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param tenantID
     * @param userID
     * @return
     */
    @Query(" from User u where u.tenantID=?1 and u.userID=?2 ")
    User findBy(long tenantID, String userID);

    @Modifying
    @Query("delete from User u where u.tenantID=?1 and u.userID=?2 ")
    void deleteBy(long tenantID, String userID);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
