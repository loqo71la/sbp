package dev.loqo71la.bp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.loqo71la.bp.common.contant.DtoConstant;

import java.util.UUID;

/**
 * Wraps an Account
 *
 * @param id             account id.
 * @param accountNumber  unique account number.
 * @param type           account type
 * @param initialBalance initial balance.
 * @param status         account status.
 * @param clientId       associated client id.
 */
public record AccountDto(
        @JsonProperty(value = DtoConstant.ID) UUID id,
        @JsonProperty(value = DtoConstant.ACCOUNT_NUMBER, required = true) String accountNumber,
        @JsonProperty(value = DtoConstant.TYPE, required = true) String type,
        @JsonProperty(value = DtoConstant.INITIAL_BALANCE) double initialBalance,
        @JsonProperty(value = DtoConstant.STATUS) boolean status,
        @JsonProperty(value = DtoConstant.CLIENT_ID, required = true) UUID clientId
) {
}
