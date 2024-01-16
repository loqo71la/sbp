package dev.loqo71la.sbp.transaction.controller;

import dev.loqo71la.sbp.base.controller.BaseController;
import dev.loqo71la.sbp.base.service.CrudService;
import dev.loqo71la.sbp.transaction.model.Transaction;
import dev.loqo71la.sbp.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages the http request for transactions.
 */
@RestController
@RequestMapping("/api/transactions")
public class TransactionController extends BaseController<Transaction> {

    /**
     * Auto-injects a proper transaction service.
     */
    @Autowired
    private TransactionService transactionService;

    /**
     * Gets the transaction service.
     *
     * @return the transaction service.
     */
    @Override
    protected CrudService<Transaction> getService() {
        return transactionService;
    }
}
