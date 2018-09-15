/**
 * All Rights Reserved. Private and Confidential. May not be
 * disclosed without permission.
 */
package com.sgutti.usermgt.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
 
 
/**
 * @author Shanmu
 * @date Sep 15, 2018 3:49:36 PM
 *
 */
@Entity
@Table(name = "BA_ROLE")
public class Role extends BaseEntity {
  // --------------------------------------------------------------- Constants
  private static final long serialVersionUID = -1759965866316826372L;
  // --------------------------------------------------------- Class Variables
  // ----------------------------------------------------- Static Initializers
  // ------------------------------------------------------ Instance Variables
  private Long roleID;
  private String name;
  private String description;
  private Collection<Permission> permissions;

  // ------------------------------------------------------------ Constructors
  /**
   * Create a new <code>Role</code>
   */
  public Role() {
    super();
  }

  // ---------------------------------------------------------- Public Methods
  /**
   * @return Returns the roleID.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ROLE_ID", nullable = false)
  public Long getRoleID() {
    return roleID;
  }

  /**
   * @param roleID
   *          The roleID to set.
   */
  public void setRoleID(final Long roleID) {
    this.roleID = roleID;
  }

  /**
   * @return Returns the name.
   */
  @Column(name = "NAME", nullable = false, length = 50)
  public String getName() {
    return name;
  }

  /**
   * @param name
   *          The name to set.
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
   *          The description to set.
   */
  public void setDescription(final String description) {
    this.description = description;
  }

  /**
   * @return Returns the permissions.
   */
  @ManyToMany(fetch = FetchType.EAGER, targetEntity = Permission.class,
      cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
  @JoinTable(name = "BA_ROLES_PERMISSIONS", joinColumns = @JoinColumn(
      name = "ROLE_ID"), inverseJoinColumns = @JoinColumn(
      name = "PERMISSION_ID"))
  public Collection<Permission> getPermissions() {
    return permissions;
  }

  /**
   * @param permissions
   *          The permissions to set.
   */
  public void setPermissions(final Collection<Permission> permissions) {
    this.permissions = permissions;
  }
  // ------------------------------------------------------- Protected Methods
  // --------------------------------------------------------- Default Methods
  // --------------------------------------------------------- Private Methods
  // ---------------------------------------------------------- Static Methods
  // ----------------------------------------------------------- Inner Classes
}
