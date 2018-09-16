/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.usermgt.data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Shanmu
 * @date Sep 16, 2018 1:14:47 PM
 */
public abstract class BaseUser implements Serializable {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = -3923059919920134491L;
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

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>BaseUser</code>
     */
    public BaseUser() {
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
    public void setUserID(String userID) {
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
    public void setPassword(String password) {
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
    public void setOnline(boolean online) {
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
    public void setEnabled(boolean enabled) {
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
    public void setAccountExpired(boolean accountExpired) {
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
    public void setAccountLocked(boolean accountLocked) {
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
    public void setCredentialsExpired(boolean credentialsExpired) {
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
    public void setExpireDate(Date expireDate) {
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
    public void setFailedLoginCounter(Integer failedLoginCounter) {
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
    public void setTerminationDate(Date terminationDate) {
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
    public void setLastLoginDate(Date lastLoginDate) {
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
    public void setLanguageId(String languageId) {
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
    public void setFirstName(String firstName) {
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
    public void setLastName(String lastName) {
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
    public void setMiddleName(String middleName) {
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
    public void setDateOfBirth(Date dateOfBirth) {
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
    public void setGenderCode(String genderCode) {
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
    public void setPhoneNumber(String phoneNumber) {
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
    public void setImage(byte[] image) {
        this.image = image;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
