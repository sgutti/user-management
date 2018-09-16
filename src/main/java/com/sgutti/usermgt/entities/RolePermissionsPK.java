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
        result = prime * result
                + ((permissionID == null) ? 0 : permissionID.hashCode());
        result = prime * result + ((roleID == null) ? 0 : roleID.hashCode());
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
        RolePermissionsPK other = (RolePermissionsPK) obj;
        if (permissionID == null) {
            if (other.permissionID != null) {
                return false;
            }
        } else if (!permissionID.equals(other.permissionID))
            return false;
        if (roleID == null) {
            if (other.roleID != null) {
                return false;
            }
        } else if (!roleID.equals(other.roleID)) {
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
