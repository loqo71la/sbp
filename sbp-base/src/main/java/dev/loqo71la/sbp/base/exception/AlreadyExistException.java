package dev.loqo71la.sbp.base.exception;

import dev.loqo71la.sbp.base.constant.ResponseConstant;

/**
 * Exception to describe when an operation is unauthorized.
 */
public class AlreadyExistException extends RuntimeException {

    /**
     * Creates a new instance of AlreadyExistException.
     *
     * @param id    model id.
     */
    public AlreadyExistException(String id) {
        super(String.format(ResponseConstant.ALREADY_EXIST, id));
    }
}
