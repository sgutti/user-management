/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * @author Shanmu
 * @date Sep 15, 2018 3:50:17 PM
 */
@Entity
@Table(name = "BA_USER")
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -2659828617752135910L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private String userID;
    private String password;
    private boolean online;
    private boolean enabled;
    private boolean accountExpired;
    private boolean accountLocked;
    private boolean credentialsExpired;
    // date in which password must be reset, nullable
    private Date expireDate;
    // locks user account when failed login attempts exceed the configurable
    // limit
    private Integer failedLoginCounter;
    // date of termination of the user account, null if active.
    private Date terminationDate;
    private Date lastLoginDate;
    private String languageId;
    private String firstName;
    private String lastName;
    private String middleName;
    private Date dateOfBirth;
    private String genderCode;
    private String phoneNumber;
    private byte[] image;
    private Collection<Role> roles;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>User</code>
     */
    public User() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the userID.
     */
    @Id
    @Column(name = "USER_ID", nullable = false, unique = true, length = 200)
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID
     *            The userID to set.
     */
    public void setUserID(final String userID) {
        this.userID = userID;
    }

    /**
     * @return Returns the password.
     */
    @Column(name = "PASSWORD", nullable = false, length = 200)
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            The password to set.
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * @return Returns the online.
     */
    @Column(name = "IS_ONLINE", nullable = true)
    public boolean isOnline() {
        return online;
    }

    /**
     * @param online
     *            The online to set.
     */
    public void setOnline(final boolean online) {
        this.online = online;
    }

    /**
     * @return Returns the enabled.
     */
    @Column(name = "ACTIVE", nullable = true)
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     *            The enabled to set.
     */
    public void setEnabled(final boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return Returns the accountExpired.
     */
    @Column(name = "ACCOUNT_EXPIRED", nullable = true)
    public boolean isAccountExpired() {
        return accountExpired;
    }

    /**
     * @param accountExpired
     *            The accountExpired to set.
     */
    public void setAccountExpired(final boolean accountExpired) {
        this.accountExpired = accountExpired;
    }

    /**
     * @return Returns the accountLocked.
     */
    @Column(name = "ACCOUNT_LOCKED", nullable = true)
    public boolean isAccountLocked() {
        return accountLocked;
    }

    /**
     * @param accountLocked
     *            The accountLocked to set.
     */
    public void setAccountLocked(final boolean accountLocked) {
        this.accountLocked = accountLocked;
    }

    /**
     * @return Returns the credentialsExpired.
     */
    @Column(name = "CREDENTIAL_EXPIRED", nullable = true)
    public boolean isCredentialsExpired() {
        return credentialsExpired;
    }

    /**
     * @param credentialsExpired
     *            The credentialsExpired to set.
     */
    public void setCredentialsExpired(final boolean credentialsExpired) {
        this.credentialsExpired = credentialsExpired;
    }

    /**
     * @return Returns the expireDate.
     */
    @Column(name = "EXPIRE_DATE", nullable = true)
    public Date getExpireDate() {
        return expireDate;
    }

    /**
     * @param expireDate
     *            The expireDate to set.
     */
    public void setExpireDate(final Date expireDate) {
        this.expireDate = expireDate;
    }

    /**
     * @return Returns the failedLoginCounter.
     */
    @Column(name = "FAILED_COUNT", nullable = true)
    public Integer getFailedLoginCounter() {
        return failedLoginCounter;
    }

    /**
     * @param failedLoginCounter
     *            The failedLoginCounter to set.
     */
    public void setFailedLoginCounter(final Integer failedLoginCounter) {
        this.failedLoginCounter = failedLoginCounter;
    }

    /**
     * @return Returns the terminationDate.
     */
    @Column(name = "TERMINATION_DATE", nullable = true)
    public Date getTerminationDate() {
        return terminationDate;
    }

    /**
     * @param terminationDate
     *            The terminationDate to set.
     */
    public void setTerminationDate(final Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    /**
     * @return Returns the languageId.
     */
    @Column(name = "LANGUAGE_ID", nullable = true, length = 5)
    public String getLanguageId() {
        return languageId;
    }

    /**
     * @param languageId
     *            The languageId to set.
     */
    public void setLanguageId(final String languageId) {
        this.languageId = languageId;
    }

    /**
     * @return Returns the lastLoginDate.
     */
    @Column(name = "LAST_LOGIN_DATE", nullable = true)
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * @param lastLoginDate
     *            The lastLoginDate to set.
     */
    public void setLastLoginDate(final Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * @return Returns the roles.
     */
    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany(targetEntity = Role.class,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "BA_USER_ROLES",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
    public Collection<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles
     *            The roles to set.
     */
    public void setRoles(final Collection<Role> roles) {
        this.roles = roles;
    }

    /**
     * @return Returns the firstName.
     */
    @Column(name = "FIRST_NAME", nullable = false, length = 200)
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            The firstName to set.
     */
    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Returns the lastName.
     */
    @Column(name = "LAST_NAME", nullable = false, length = 200)
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            The lastName to set.
     */
    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Returns the middleName.
     */
    @Column(name = "MIDDLE_NAME", nullable = true, length = 200)
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName
     *            The middleName to set.
     */
    public void setMiddleName(final String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return Returns the dateOfBirth.
     */
    @Column(name = "BIRTH_DATE", nullable = true)
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth
     *            The dateOfBirth to set.
     */
    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return Returns the genderCode.
     */
    @Column(name = "GENDER_CODE", nullable = true)
    public String getGenderCode() {
        return genderCode;
    }

    /**
     * @param genderCode
     *            The genderCode to set.
     */
    public void setGenderCode(final String genderCode) {
        this.genderCode = genderCode;
    }

    /**
     * @return Returns the emailID.
     */
    /**
     * @return Returns the phoneNumber.
     */
    @Column(name = "PHONE_NUM", nullable = false, length = 10)
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber
     *            The phoneNumber to set.
     */
    public void setPhoneNumber(final String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return
     */
    @Column(name = "PHOTO", nullable = true)
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image
     */
    public void setImage(final byte[] image) {
        this.image = image;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
