/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sgutti.usermgt.entities.Permission;

/**
 * @author Shanmu
 * @date Jul 7, 2014 7:13:06 PM
 */
public interface PermissionDAO extends JpaRepository<Permission, Long> {
    // --------------------------------------------------------------- Constants
    String NAME = "permissionDAO";

    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    // ------------------------------------------------------------ Constructors
    // ---------------------------------------------------------- Public Methods
    /**
     * @param ids
     * @return
     */
    @Query(" from Permission p where p.permissionID in (?1) ")
    List<Permission> findBy(List<Long> ids);

    /**
     * @param type
     * @return
     */
    @Query(" from Permission p where p.type=?1 ")
    List<Permission> findByType(int type);
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
