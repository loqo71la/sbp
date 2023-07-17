package dev.loqo71la.bp.repository;

import dev.loqo71la.bp.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends CrudRepository<Client, UUID>, PagingAndSortingRepository<Client, UUID> {

    /**
     * Returns whether a client with the given code exists.
     *
     * @param fullName full name.
     * @return true if a client exists, false otherwise.
     */
    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Client c WHERE c.fullName = :fullName")
    boolean existsByFullName(String fullName);
}
