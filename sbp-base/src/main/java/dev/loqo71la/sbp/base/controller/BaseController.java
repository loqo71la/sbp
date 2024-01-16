package dev.loqo71la.sbp.base.controller;

import dev.loqo71la.sbp.base.dto.PageDto;
import dev.loqo71la.sbp.base.dto.ResponseDto;
import dev.loqo71la.sbp.base.model.Model;
import dev.loqo71la.sbp.base.service.CrudService;
import dev.loqo71la.sbp.base.util.HttpUtil;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import static dev.loqo71la.sbp.base.util.HttpUtil.success;

/**
 * Base controller to manage communication between http requests and services.
 *
 * @param <T> model instance.
 */
public abstract class BaseController<T extends Model> {

    /**
     * HTTP GetAll method.
     *
     * @param page  current page of the pagination.
     * @param limit total item per page.
     * @return a list of model.
     */
    @GetMapping
    public PageDto<T> getAll(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "50") int limit) {
        var pageable = buildPageable(page, limit);
        var pageModel = getService().readAll(pageable);
        return toPageDto(pageModel);
    }

    /**
     * HTTP GetById method.
     *
     * @param id of selected model.
     * @return a single model.
     */
    @GetMapping("/{id}")
    public T getById(@PathVariable long id) {
        return getService().read(id);
    }

    /**
     * HTTP Post method.
     *
     * @param model to be saved.
     * @return the details of the processed request.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto post(@RequestBody T model) {
        getService().create(model);
        return success(HttpUtil.Action.CREATED);
    }

    /**
     * HTTP Put method.
     *
     * @param id    of selected model.
     * @param model to be updated.
     * @return the details of the processed request.
     */
    @PutMapping("/{id}")
    public ResponseDto put(@PathVariable long id, @RequestBody T model) {
        getService().update(id, model);
        return success(HttpUtil.Action.UPDATED);
    }

    /**
     * HTTP Delete method.
     *
     * @param id of selected model.
     * @return the details of the processed request.
     */
    @DeleteMapping("/{id}")
    public ResponseDto delete(@PathVariable long id) {
        getService().delete(id);
        return success(HttpUtil.Action.DELETED);
    }


    /**
     * Gets the current model service.
     *
     * @return the model service.
     */
    protected abstract CrudService<T> getService();

    /**
     * Builds a pageable instance based on page and limit.
     *
     * @param page  page number.
     * @param limit page limit.
     * @return a pageable.
     */
    protected Pageable buildPageable(int page, int limit) {
        return PageRequest.of(Math.max(page - 1, 0), Math.max(limit, 1));
    }

    protected PageDto<T> toPageDto(Page<T> page) {
        return new PageDto<>((int) page.getTotalElements(),
                Math.max(page.getTotalPages(), 1),
                page.getNumber() + 1,
                page.getContent());
    }
}
