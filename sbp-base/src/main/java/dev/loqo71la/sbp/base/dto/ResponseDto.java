package dev.loqo71la.sbp.base.dto;

/**
 * Wraps a HTTP response.
 *
 * @param status  response status.
 * @param message response message.
 */
public record ResponseDto(String status, String message) {
}
