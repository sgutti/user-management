/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Shanmu
 * @date Jul 7, 2014 5:27:21 PM
 */
@Entity
@Table(name = "BA_PERM_ACTIONS")
public class PermissionAction implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -7013956769496214844L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long actionID;

    private String name;

    private Integer mask;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>PermissionAction</code>
     */
    public PermissionAction() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the actionID.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ACTION_ID", nullable = false)
    public Long getActionID() {
        return actionID;
    }

    /**
     * @param actionID
     *            The actionID to set.
     */
    public void setActionID(Long actionID) {
        this.actionID = actionID;
    }

    /**
     * @return Returns the name.
     */
    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return Returns the mask.
     */
    @Column(name = "MASK", nullable = false)
    public Integer getMask() {
        return mask;
    }

    /**
     * @param mask
     *            The mask to set.
     */
    public void setMask(Integer mask) {
        this.mask = mask;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
