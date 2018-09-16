/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

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

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((roleID == null) ? 0 : roleID.hashCode());
        result = prime * result + ((userID == null) ? 0 : userID.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        UserRolePK other = (UserRolePK) obj;
        if (roleID == null) {
            if (other.roleID != null) {
                return false;
            }
        } else if (!roleID.equals(other.roleID)) {
            return false;
        }
        if (userID == null) {
            if (other.userID != null) {
                return false;
            }
        } else if (!userID.equals(other.userID)) {
            return false;
        }
        return true;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
