package dev.loqo71la.sbp.transaction.repository;

import dev.loqo71la.sbp.base.repository.BaseRepository;
import dev.loqo71la.sbp.transaction.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TransactionRepository extends BaseRepository<Transaction> {

    Page<Transaction> findAllByAccountNumber(Pageable pageable, String account);

    Page<Transaction> findAllByDate(Pageable pageable, Date date);

    Page<Transaction> findAllByAccountNumberAndDate(Pageable pageable, String accountNumber, Date date);
}
