/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.data;

import com.sgutti.core.base.BaseData;

/**
 * @author Shanmu
 * @date Jul 10, 2014 12:22:25 PM
 */
public class PermissionData implements BaseData {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long permissionID;
    private String name;
    private String description;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>PermissionData</code>
     */
    public PermissionData() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the permissionID.
     */
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
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
