package dev.loqo71la.bp.repository;

import dev.loqo71la.bp.model.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, UUID>, PagingAndSortingRepository<Transaction, UUID> {
}
