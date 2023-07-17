package dev.loqo71la.bp.common.exception;

import dev.loqo71la.bp.common.contant.ResponseConstant;

/**
 * Exception to describe when an operation is unauthorized.
 */
public class AlreadyExistException extends RuntimeException {

    /**
     * Creates a new instance of AlreadyExistException.
     *
     * @param model model name.
     * @param id    model id.
     */
    public AlreadyExistException(String model, String id) {
        super(String.format(ResponseConstant.ALREADY_EXIST, model, id));
    }
}
