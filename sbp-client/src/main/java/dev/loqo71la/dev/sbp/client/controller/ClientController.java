package dev.loqo71la.dev.sbp.client.controller;

import dev.loqo71la.sbp.base.controller.BaseController;
import dev.loqo71la.sbp.base.service.CrudService;
import dev.loqo71la.dev.sbp.client.model.Client;
import dev.loqo71la.dev.sbp.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Manages the http request for clients.
 */
@RestController
@RequestMapping("/api/clients")
public class ClientController extends BaseController<Client> {

    /**
     * Auto-injects a proper client service.
     */
    @Autowired
    private ClientService clientService;

    /**
     * Gets the client service.
     *
     * @return the client service.
     */
    @Override
    protected CrudService<Client> getService() {
        return clientService;
    }
}
