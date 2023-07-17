package dev.loqo71la.bp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.loqo71la.bp.common.contant.DtoConstant;

/**
 * Wraps a HTTP response.
 *
 * @param status  response status.
 * @param message response message.
 */
public record ResponseDto(
        @JsonProperty(DtoConstant.STATUS) String status,
        @JsonProperty(DtoConstant.MESSAGE) String message
) {
}
