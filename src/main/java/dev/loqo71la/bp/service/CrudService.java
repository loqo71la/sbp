package dev.loqo71la.bp.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;
import java.util.UUID;

/**
 * Defines the CRUD methods.
 *
 * @param <T> represents a dto.
 */
public interface CrudService<T> {

    /**
     * Creates a new model.
     *
     * @param dto to be created.
     */
    void create(T dto);

    /**
     * Reads all models with specific filter.
     *
     * @param pageable request pagination fields.
     * @return the list of models.
     */
    Page<T> readAll(Pageable pageable);

    /**
     * Reads a single model for specific id.
     *
     * @param id model id.
     * @return the model.
     */
    T read(UUID id);

    /**
     * Updates a specific model.
     *
     * @param id  model id.
     * @param dto to be updated.
     */
    void update(UUID id, T dto);

    /**
     * Deletes and specific model.
     *
     * @param id model id.
     */
    void delete(UUID id);
}
