package dev.loqo71la.sbp.account.repository;

import dev.loqo71la.sbp.account.model.Account;
import dev.loqo71la.sbp.base.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Provides additional methods to retrieve accounts using the pagination abstraction.
 */
@Repository
public interface AccountRepository extends BaseRepository<Account> {

    /**
     * Returns whether a client with the given code exists.
     *
     * @param accountNumber account number.
     * @return true if an account exists, false otherwise.
     */
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END FROM Account a WHERE a.accountNumber = :accountNumber")
    boolean existsByAccountNumber(String accountNumber);
}
