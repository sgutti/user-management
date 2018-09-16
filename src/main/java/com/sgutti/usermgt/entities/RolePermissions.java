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
 * @date Sep 15, 2018 3:49:42 PM
 */
@Entity
@Table(name = "BA_ROLE_PERMISSIONS")
@IdClass(RolePermissionsPK.class)
public class RolePermissions implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -3975543249406890034L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long permissionID;
    private Long roleID;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>RolesPermissions</code>
     */
    public RolePermissions() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the permissionID.
     */
    @Id
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
