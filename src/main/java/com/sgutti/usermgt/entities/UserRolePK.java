/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

/**
 * @author Shanmu
 * @date Sep 15, 2018 3:50:27 PM
 */
@Embeddable
public class UserRolePK implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -5094482122847387408L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String userID;

    private Long roleID;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>UserRolePK</code>
     */
    public UserRolePK() {
        super();
    }

    /**
     * Create a new <code>UserRolePK</code>
     * 
     * @param userID
     * @param roleID
     */
    public UserRolePK(final String userID, final Long roleID) {
        super();
        this.userID = userID;
        this.roleID = roleID;
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the userID.
     */
    @Id
    @Column(name = "USER_ID", nullable = false, unique = true, length = 200)
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
    @Column(name = "ROLE_ID", nullable = false)
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
