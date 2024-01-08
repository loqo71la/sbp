package dev.loqo71la.dev.sbp.client.repository;

import dev.loqo71la.sbp.base.repository.BaseRepository;
import dev.loqo71la.dev.sbp.client.model.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends BaseRepository<Client> {

    /**
     * Returns whether a client with the given code exists.
     *
     * @param userName unique username.
     * @return true if a client exists, false otherwise.
     */
    boolean existsByUserName(String userName);
}
