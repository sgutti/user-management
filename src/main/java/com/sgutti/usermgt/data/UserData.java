/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.data;

import java.util.Date;

import com.sgutti.core.base.BaseData;

/**
 * @author Shanmu
 * @date Jul 7, 2014 7:14:27 PM
 */
public class UserData implements BaseData {
    // --------------------------------------------------------------- Constants
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
    private String role;
    private Long roleID;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>UserData</code>
     */
    public UserData() {
        super();
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the userID.
     */
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
     * @return Returns the lastLoginDate.
     */
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
     * @return Returns the languageId.
     */
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
     * @return Returns the firstName.
     */
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
     * @return Returns the phoneNumber.
     */
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
     * @return Returns the image.
     */
    public byte[] getImage() {
        return image;
    }

    /**
     * @param image
     *            The image to set.
     */
    public void setImage(final byte[] image) {
        this.image = image;
    }

    /**
     * @return Returns the role.
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     *            The role to set.
     */
    public void setRole(final String role) {
        this.role = role;
    }

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
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
