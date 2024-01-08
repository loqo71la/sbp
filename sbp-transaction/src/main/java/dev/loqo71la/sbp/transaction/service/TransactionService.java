package dev.loqo71la.sbp.transaction.service;

import dev.loqo71la.sbp.base.repository.BaseRepository;
import dev.loqo71la.sbp.base.service.BaseService;
import dev.loqo71la.sbp.transaction.model.Transaction;
import dev.loqo71la.sbp.transaction.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService extends BaseService<Transaction> {

    /**
     * Auto-inject a proper transaction repository.
     */
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void update(long id, Transaction newTransaction) {
    }

    @Override
    protected BaseRepository<Transaction> getRepository() {
        return transactionRepository;
    }
}
