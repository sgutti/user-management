/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.data;

import java.util.List;

import com.sgutti.core.base.BaseData;

/**
 * @author Shanmu
 * @date Jul 7, 2014 8:17:15 PM
 */
public class RoleData implements BaseData {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long roleID;
    private String name;
    private String description;
    private List<PermissionData> permissions;
    private List<Long> permissionIDs;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>RoleData</code>
     */
    public RoleData() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
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
    public void setRoleID(final Long roleID) {
        this.roleID = roleID;
    }

    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return Returns the description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     *            The description to set.
     */
    public void setDescription(final String description) {
        this.description = description;
    }

    /**
     * @return Returns the permissions.
     */
    public List<PermissionData> getPermissions() {
        return permissions;
    }

    /**
     * @param permissions
     *            The permissions to set.
     */
    public void setPermissions(final List<PermissionData> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return Returns the permissionIDs.
     */
    public List<Long> getPermissionIDs() {
        return permissionIDs;
    }

    /**
     * @param permissionIDs
     *            The permissionIDs to set.
     */
    public void setPermissionIDs(final List<Long> permissionIDs) {
        this.permissionIDs = permissionIDs;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
