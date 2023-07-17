package dev.loqo71la.bp.controller;

import dev.loqo71la.bp.common.contant.ResponseConstant;
import dev.loqo71la.bp.common.contant.RouteConstant;
import dev.loqo71la.bp.dto.PageDto;
import dev.loqo71la.bp.dto.ResponseDto;
import dev.loqo71la.bp.service.CrudService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Base controller to manage communication between http requests and services.
 *
 * @param <T> dto instance.
 */
public abstract class BaseController<T> {

    /**
     * Stores the crud service instance.
     */
    protected CrudService<T> service;

    /**
     * HTTP GetAll method.
     *
     * @param page  current page of the pagination.
     * @param limit total item per page.
     * @return a list of dto.
     */
    @GetMapping
    public PageDto<T> getAll(@RequestParam(defaultValue = "1") int page,
                             @RequestParam(defaultValue = "50") int limit) {
        var pageable = PageRequest.of(Math.max(page - 1, 0), limit);
        var modelPage = service.readAll(pageable);
        return new PageDto<>(
                (int) modelPage.getTotalElements(),
                modelPage.getTotalPages(),
                page,
                modelPage.stream()
                        .collect(Collectors.toList())
        );
    }

    /**
     * HTTP GetById method.
     *
     * @param id of selected dto.
     * @return a single dto.
     */
    @GetMapping(RouteConstant.ID_PARAM)
    public T getById(@PathVariable UUID id) {
        return service.read(id);
    }

    /**
     * HTTP Post method.
     *
     * @param dto to be saved.
     * @return the details of the processed request.
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseDto post(@RequestBody T dto) {
        service.create(dto);
        return success(ResponseConstant.CREATE);
    }

    /**
     * HTTP Put method.
     *
     * @param id  of selected dto.
     * @param dto to be updated.
     * @return the details of the processed request.
     */
    @PutMapping(RouteConstant.ID_PARAM)
    public ResponseDto put(@PathVariable UUID id, @RequestBody T dto) {
        service.update(id, dto);
        return success(ResponseConstant.UPDATE);
    }

    /**
     * HTTP Delete method.
     *
     * @param id of selected dto.
     * @return the details of the processed request.
     */
    @DeleteMapping(RouteConstant.ID_PARAM)
    public ResponseDto delete(@PathVariable UUID id) {
        service.delete(id);
        return success(ResponseConstant.REMOVE);
    }

    /**
     * Builds a success http response.
     *
     * @param action to be set.
     * @return success response
     */
    private ResponseDto success(String action) {
        var message = String.format(ResponseConstant.SUCCESSFULLY, action);
        return new ResponseDto(ResponseConstant.SUCCESS, message);
    }
}
