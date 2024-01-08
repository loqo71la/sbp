package dev.loqo71la.sbp.base.service;

import dev.loqo71la.sbp.base.model.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Defines the CRUD methods.
 *
 * @param <T> model instance.
 */
public interface CrudService<T extends Model> {

    /**
     * Creates a new model.
     *
     * @param model to be created.
     */
    void create(T model);

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
    T read(long id);

    /**
     * Updates a specific model.
     *
     * @param id    model id.
     * @param model to be updated.
     */
    void update(long id, T model);

    /**
     * Deletes and specific model.
     *
     * @param id model id.
     */
    void delete(long id);
}
