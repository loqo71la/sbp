package dev.loqo71la.bp.controller;

import dev.loqo71la.bp.common.contant.RouteConstant;
import dev.loqo71la.bp.dto.TransactionDto;
import dev.loqo71la.bp.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages the http request for transactions.
 */
@RestController
@RequestMapping(RouteConstant.TRANSACTION_URL)
public class TransactionController extends BaseController<TransactionDto> {

    /**
     * Auto-injects a proper service.
     *
     * @param transactionService CrudService implementation for transactions.
     */
    @Autowired
    public void setService(TransactionService transactionService) {
        super.service = transactionService;
    }
}
