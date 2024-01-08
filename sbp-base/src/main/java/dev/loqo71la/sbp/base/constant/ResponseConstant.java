package dev.loqo71la.sbp.base.constant;

/**
 * Constants for HTTP Responses.
 */
public final class ResponseConstant {

    /**
     * Stores the pattern message for 'already exist' error.
     */
    public static final String ALREADY_EXIST = "Resource with ID [%s] already exists.";

    /**
     * Stores the pattern message for 'not found' error.
     */
    public static final String NOT_FOUND = "Resource with ID [%s] was not found.";

    /**
     * Stores the pattern message for 'not found' error.
     */
    public static final String INVALID_TYPE = "Resouece with type '%s' is invalid.";

    /**
     * Stores the pattern message of successfully action.
     */
    public static final String SUCCESSFULLY = "Resource has been %s successfully.";

    /**
     * Stores the constant 'success'.
     */
    public static final String SUCCESS = "success";

    /**
     * Stores the constant 'error'.
     */
    public static final String ERROR = "error";

    /**
     * Default Constructor.
     */
    private ResponseConstant() {
    }
}
