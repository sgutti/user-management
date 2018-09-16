/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Shanmu
 * @date Sep 15, 2018 3:50:33 PM
 */
@Entity
@Table(name = "BA_USER_ROLES")
@IdClass(UserRolePK.class) 
public class UserRoles implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 3733765182639241278L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String userID;

    private Long roleID;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>UserRoles</code>
     */
    public UserRoles() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the userID.
     */
    @Id
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID
     *            The userID to set.
     */
    public void setUserID(final String userID) {
        this.userID = userID;
    }

    /**
     * @return Returns the roleID.
     */
    @Id
    public Long getRoleID() {
        return roleID;
    }

    /**
     * @param roleID
     *            The roleID to set.
     */
    public void setRoleID(final Long roleID) {
        this.roleID = roleID;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
