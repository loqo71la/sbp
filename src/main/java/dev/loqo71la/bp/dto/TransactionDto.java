package dev.loqo71la.bp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.loqo71la.bp.common.contant.DtoConstant;

import java.util.UUID;

/**
 * Wraps a Transaction.
 *
 * @param id        transaction id.
 * @param accountId associated account id.
 * @param type      transaction type.
 * @param value     transaction value.
 */
public record TransactionDto(
        @JsonProperty(value = DtoConstant.ID) UUID id,
        @JsonProperty(value = DtoConstant.ACCOUNT_ID, required = true) UUID accountId,
        @JsonProperty(value = DtoConstant.TYPE, required = true) String type,
        @JsonProperty(DtoConstant.TRANSACTION) double value
) {
}
