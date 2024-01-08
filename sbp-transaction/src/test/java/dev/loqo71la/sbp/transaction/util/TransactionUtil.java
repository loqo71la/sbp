package dev.loqo71la.bp.transaction.util;

import dev.loqo71la.bp.transaction.model.Transaction;

import java.util.Date;

import static java.util.UUID.randomUUID;

public final class TransactionUtil {

    private TransactionUtil() {}

    public static Transaction empty() {
        var transaction = new Transaction();
        transaction.setId(randomUUID());
        transaction.setDate(new Date());
        return transaction;
    }

    public static Transaction of() {
        var transaction = empty();
        return transaction;
    }
}
