package dev.loqo71la.bp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.loqo71la.bp.common.contant.DtoConstant;

import java.util.UUID;

/**
 * Wraps a client.
 *
 * @param id       client id.
 * @param fullName client full name.
 * @param address  client address
 * @param phone    client phone number.
 * @param password encrypted password.
 * @param status   client status.
 */
public record ClientDto(
        @JsonProperty(value = DtoConstant.ID) UUID id,
        @JsonProperty(value = DtoConstant.FULL_NAME, required = true) String fullName,
        @JsonProperty(value = DtoConstant.ADDRESS) String address,
        @JsonProperty(value = DtoConstant.PHONE) String phone,
        @JsonProperty(value = DtoConstant.PASSWORD, required = true) String password,
        @JsonProperty(value = DtoConstant.STATUS) boolean status
) {
}
