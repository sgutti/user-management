/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Shanmu
 * @date Sep 15, 2018 3:52:02 PM
 */
@MappedSuperclass
public class AbstractEntity implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -7760256970259070626L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Long tenantID;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>AbstractEntity</code>
     */
    public AbstractEntity() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the tenantID.
     */
    @Column(name = "TENANT_ID", nullable = false)
    public Long getTenantID() {
        return tenantID;
    }

    /**
     * @param tenantID
     *            The tenantID to set.
     */
    public void setTenantID(final Long tenantID) {
        this.tenantID = tenantID;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
