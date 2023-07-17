package dev.loqo71la.bp.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import dev.loqo71la.bp.common.contant.DtoConstant;

import java.util.UUID;

/**
 * Wraps a Report.
 *
 * @param id             transaction id.
 * @param date           transaction date.
 * @param fullName       client full name.
 * @param accountNumber  account number.
 * @param type           account type.
 * @param initialBalance account initial balance.
 * @param status         account status.
 * @param transaction    transaction value
 * @param balance        available balance.
 */
public record ReportDto(
        @JsonProperty(value = DtoConstant.ID) UUID id,
        @JsonProperty(value = DtoConstant.DATE) String date,
        @JsonProperty(value = DtoConstant.CLIENT) String fullName,
        @JsonProperty(value = DtoConstant.ACCOUNT_NUMBER) String accountNumber,
        @JsonProperty(value = DtoConstant.TYPE) String type,
        @JsonProperty(value = DtoConstant.INITIAL_BALANCE) String initialBalance,
        @JsonProperty(value = DtoConstant.STATUS) String status,
        @JsonProperty(value = DtoConstant.TRANSACTION) String transaction,
        @JsonProperty(value = DtoConstant.BALANCE) String balance
) {
}
