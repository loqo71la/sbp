package dev.loqo71la.sbp.base.util;

import dev.loqo71la.sbp.base.constant.ResponseConstant;
import dev.loqo71la.sbp.base.dto.ResponseDto;

public final class HttpUtil {

    public enum Action {
        CREATED, UPDATED, DELETED
    }

    /**
     * Builds a success http response.
     *
     * @param action to be set.
     * @return success response
     */
    public static ResponseDto success(Action action) {
        var message = String.format(ResponseConstant.SUCCESSFULLY, action);
        return new ResponseDto(ResponseConstant.SUCCESS, message);
    }

    /**
     * Builds a error result info.
     *
     * @param exception error instance.
     * @return a result info.
     */
    public static ResponseDto error(Exception exception) {
        return new ResponseDto(ResponseConstant.ERROR, exception.getMessage());
    }
}
