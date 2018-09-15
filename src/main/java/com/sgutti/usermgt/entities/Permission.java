/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Shanmu
 * @date Sep 15, 2018 3:49:26 PM
 */
@Entity
@Table(name = "BA_PERMISSIONS")
public class Permission implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 2735685674103566146L;

    public static final int CORE = -1;

    public static final int SYSTEM = 0;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long permissionID;

    private String name;

    private String description;

    private Integer type;

    private List<PermissionAction> actions;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>Permission</code>
     */
    public Permission() {
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
     * @return Returns the name.
     */
    @Column(name = "NAME", nullable = false, length = 50, unique = true)
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
    @Column(name = "DESCRIPTION", nullable = true, length = 200)
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
     * @return Returns the type.
     */
    @Column(name = "TYPE", nullable = false)
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     *            The type to set.
     */
    public void setType(final Integer type) {
        this.type = type;
    }

    /**
     * @return Returns the actions.
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = PermissionAction.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "BA_PERM_ACTIONS",
            joinColumns = @JoinColumn(name = "PERMISSION_ID"),
            inverseJoinColumns = @JoinColumn(name = "ACTION_ID"))
    public List<PermissionAction> getActions() {
        return actions;
    }

    /**
     * @param actions
     *            The actions to set.
     */
    public void setActions(final List<PermissionAction> actions) {
        this.actions = actions;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
