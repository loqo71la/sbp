package dev.loqo71la.bp.common.exception;

import dev.loqo71la.bp.common.contant.ResponseConstant;

public class InvalidTypeException extends RuntimeException {

    public InvalidTypeException(String model, String type) {
        super(String.format(ResponseConstant.INVALID_TYPE, model, type));
    }
}
