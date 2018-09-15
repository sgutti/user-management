/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.core.base;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Shanmu
 * @date Sep 15, 2018 5:06:26 PM
 */
public abstract class BaseServicePojo implements BaseService {
    // --------------------------------------------------------------- Constants
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    @Autowired
    private Mapper mapper;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>BaseServicePojo</code>
     */
    public BaseServicePojo() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the mapper.
     */
    public Mapper getMapper() {
        return mapper;
    }

    /**
     * @param mapper
     *            The mapper to set.
     */
    public void setMapper(final Mapper mapper) {
        this.mapper = mapper;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
