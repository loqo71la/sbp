package dev.loqo71la.sbp.base.service;

import dev.loqo71la.sbp.base.exception.NotFoundException;
import dev.loqo71la.sbp.base.model.Model;
import dev.loqo71la.sbp.base.repository.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;

public abstract class BaseService<T extends Model> implements CrudService<T> {
    @Override
    public Page<T> readAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    @Override
    public void create(T model) {
        var now = new Date();
        model.setCreatedAt(now);
        model.setUpdatedAt(now);

        getRepository().save(model);
    }

    @Override
    public T read(long id) {
        return getRepository()
                .findById(id)
                .orElseThrow(() -> new NotFoundException(String.valueOf(id)));
    }

    @Override
    public void delete(long id) {
        getRepository().deleteById(id);
    }

    /**
     * Gets the current model repository.
     *
     * @return the model repository.
     */
    protected abstract BaseRepository<T> getRepository();
}
