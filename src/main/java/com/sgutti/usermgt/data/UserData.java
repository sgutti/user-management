/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.data;

import com.sgutti.core.base.BaseData;

/**
 * @author Shanmu
 * @date Jul 7, 2014 7:14:27 PM
 */
public class UserData extends BaseUser implements BaseData {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String role;
    private Long roleID;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>UserData</code>
     */
    public UserData() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the role.
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     *            The role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * @return Returns the roleID.
     */
    public Long getRoleID() {
        return roleID;
    }

    /**
     * @param roleID
     *            The roleID to set.
     */
    public void setRoleID(Long roleID) {
        this.roleID = roleID;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
