package dev.loqo71la.bp.repository;

import dev.loqo71la.bp.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Provides additional methods to retrieve accounts using the pagination abstraction.
 */
@Repository
public interface AccountRepository extends CrudRepository<Account, UUID>, PagingAndSortingRepository<Account, UUID> {

    /**
     * Returns whether a client with the given code exists.
     *
     * @param accountNumber account number.
     * @return true if an account exists, false otherwise.
     */
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Account a WHERE a.accountNumber = :accountNumber")
    boolean existsByAccountNumber(String accountNumber);
}
