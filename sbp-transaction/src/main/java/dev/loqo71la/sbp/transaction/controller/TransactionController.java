package dev.loqo71la.sbp.transaction.controller;

import dev.loqo71la.sbp.base.controller.BaseController;
import dev.loqo71la.sbp.base.service.CrudService;
import dev.loqo71la.sbp.transaction.model.Transaction;
import dev.loqo71la.sbp.transaction.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages the http request for transactions.
 */
@RestController
@RequestMapping("/api/transactions")
public class TransactionController extends BaseController<Transaction> {

    /**
     * Auto-injects a proper transaction service.
     */
    @Autowired
    private TransactionService transactionService;

    /**
     * HTTP Post method.
     *
     * @return the details of the processed request.
     */
//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public ResponseDto post(@RequestBody TransactionDto dto) {
////        var model = mapper.toModel(dto);
////        repository.save(model);
//        return HttpUtil.success(HttpUtil.Action.CREATED);
//    }
    @Override
    protected CrudService<Transaction> getService() {
        return transactionService;
    }

//    @GetMapping
//    public PageDto<TransactionDto> getAll(@RequestParam(defaultValue = "1") int page,
//                                          @RequestParam(defaultValue = "50") int limit) {
//        var pageable = PageRequest.of(Math.max(page - 1, 0), limit);
//        var result = repository.findAll(pageable);
//        return new PageDto<>(
//                (int) result.getTotalElements(),
//                result.getTotalPages(),
//                result.getNumber(),
//                result.get()
//                        .map(mapper::toDto)
//                        .collect(Collectors.toList())
//        );
//    }
}
