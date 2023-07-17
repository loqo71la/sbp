package dev.loqo71la.bp.model;

import dev.loqo71la.bp.common.contant.DtoConstant;
import dev.loqo71la.bp.common.contant.ResponseConstant;
import dev.loqo71la.bp.common.exception.InvalidTypeException;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum AccountType {
    CHECKING(ResponseConstant.CHECKING),
    SAVINGS(ResponseConstant.SAVINGS);

    private final String label;

    AccountType(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }

    public static AccountType valueOfLabel(String label) {
        for (AccountType myEnum : values()) {
            if (myEnum.label.equalsIgnoreCase(label)) {
                return myEnum;
            }
        }
        throw new InvalidTypeException(
                DtoConstant.ACCOUNT,
                Arrays.stream(values())
                        .map(type -> type.label)
                        .collect(Collectors.joining(", "))
        );
    }
}
