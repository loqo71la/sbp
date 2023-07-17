package dev.loqo71la.bp.controller;

import dev.loqo71la.bp.common.contant.RouteConstant;
import dev.loqo71la.bp.dto.ClientDto;
import dev.loqo71la.bp.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages the http request for clients.
 */
@RestController
@RequestMapping(RouteConstant.CLIENT_URL)
public class ClientController extends BaseController<ClientDto> {

    /**
     * Auto-injects a proper service.
     *
     * @param clientService CrudService implementation for clients.
     */
    @Autowired
    public void setService(ClientService clientService) {
        super.service = clientService;
    }

}
