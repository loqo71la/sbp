package dev.loqo71la.sbp.base.exception;

import dev.loqo71la.sbp.base.constant.ResponseConstant;

public class InvalidTypeException extends RuntimeException {

    public InvalidTypeException(String type) {
        super(String.format(ResponseConstant.INVALID_TYPE, type));
    }
}
