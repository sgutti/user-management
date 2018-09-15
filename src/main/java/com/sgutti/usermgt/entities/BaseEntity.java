/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Shanmu
 * @date Sep 15, 2018 3:52:12 PM
 */
@MappedSuperclass
public class BaseEntity extends AbstractEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 474269060300128937L;

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private Date createdDate;

    private String createdBy;

    private Date modifiedDate;

    private String modifiedBy;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>BaseEntity</code>
     */
    public BaseEntity() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the createdDate.
     */
    @Column(name = "CREATED_DATE", nullable = false)
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate
     *            The createdDate to set.
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * @return Returns the createdBy.
     */
    @Column(name = "CREATED_BY", nullable = false)
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy
     *            The createdBy to set.
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return Returns the modifiedDate.
     */
    @Column(name = "MODIFIED_DATE", nullable = true)
    public Date getModifiedDate() {
        return modifiedDate;
    }

    /**
     * @param modifiedDate
     *            The modifiedDate to set.
     */
    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    /**
     * @return Returns the modifiedBy.
     */
    @Column(name = "MODIFIED_BY", nullable = true)
    public String getModifiedBy() {
        return modifiedBy;
    }

    /**
     * @param modifiedBy
     *            The modifiedBy to set.
     */
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
