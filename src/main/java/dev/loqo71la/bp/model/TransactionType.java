package dev.loqo71la.bp.model;

import dev.loqo71la.bp.common.contant.DtoConstant;
import dev.loqo71la.bp.common.contant.ResponseConstant;
import dev.loqo71la.bp.common.exception.InvalidTypeException;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum TransactionType {
    WITHDRAWAL(ResponseConstant.WITHDRAWAL),
    DEPOSIT(ResponseConstant.DEPOSIT);

    private final String label;

    TransactionType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static TransactionType valueOfLabel(String label) {
        for (var type : values()) {
            if (type.label.equalsIgnoreCase(label)) {
                return type;
            }
        }
        throw new InvalidTypeException(
                DtoConstant.TRANSACTION,
                Arrays.stream(values())
                        .map(type -> type.label)
                        .collect(Collectors.joining(", "))
        );
    }
}
