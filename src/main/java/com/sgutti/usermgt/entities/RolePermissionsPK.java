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
 * @date Sep 15, 2018 3:49:56 PM
 */
@Embeddable
public class RolePermissionsPK implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 2578665121061513708L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long permissionID;

    private Long roleID;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>RolePermissionsPK</code>
     */
    public RolePermissionsPK() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the permissionID.
     */
    @Id
    @Column(name = "PERMISSION_ID", nullable = false)
    public Long getPermissionID() {
        return permissionID;
    }

    /**
     * @param permissionID
     *            The permissionID to set.
     */
    public void setPermissionID(final Long permissionID) {
        this.permissionID = permissionID;
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
