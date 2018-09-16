/**
 * All Rights Reserved. Private and Confidential. May not be disclosed without
 * permission.
 */
package com.sgutti.core.exception;

/**
 * @author Shanmu
 * @date Sep 15, 2018 5:07:15 PM
 */
public class ApplicationException extends Exception {
    // --------------------------------------------------------------- Constants
    private static final long serialVersionUID = 7785127800768768454L;
    // --------------------------------------------------------- Class Variables
    // ----------------------------------------------------- Static Initializers
    // ------------------------------------------------------ Instance Variables
    private final String errorCode;
    private final String errorMessage;

    // ------------------------------------------------------------ Constructors
    /**
     * Create a new <code>ApplicationException</code>
     * 
     * @param errorCode
     * @param errorMessage
     */
    public ApplicationException(final String errorCode,
            final String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * Create a new <code>ApplicationException</code>
     * 
     * @param errorCode
     * @param errorMessage
     * @param cause
     */
    public ApplicationException(final String errorCode,
            final String errorMessage, Throwable cause) {
        super(cause);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    // ---------------------------------------------------------- Public Methods
    /**
     * @return Returns the errorCode.
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * @return
     */
    public String getErrorStr() {
        return errorCode + ":" + getLocalizedMessage();
    }

    /**
     * @return Returns the errorMessage.
     */
    public String getErrorMessage() {
        return errorMessage;
    }
    // ------------------------------------------------------- Protected Methods
    // --------------------------------------------------------- Default Methods
    // --------------------------------------------------------- Private Methods
    // ---------------------------------------------------------- Static Methods
    // ----------------------------------------------------------- Inner Classes
}
