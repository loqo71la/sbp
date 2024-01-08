package dev.loqo71la.sbp.base.exception;

import dev.loqo71la.sbp.base.constant.ResponseConstant;

/**
 * Exception to describe when an item not found in the system.
 */
public class NotFoundException extends RuntimeException {

    /**
     * Creates a new instance of NotFoundException.
     *
     * @param id    model id.
     */
    public NotFoundException(String id) {
        super(String.format(ResponseConstant.NOT_FOUND, id));
    }
}
