package dev.loqo71la.dev.sbp.client.service;

import dev.loqo71la.dev.sbp.client.repository.ClientRepository;
import dev.loqo71la.sbp.base.repository.BaseRepository;
import dev.loqo71la.sbp.base.service.BaseService;
import dev.loqo71la.dev.sbp.client.model.Client;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends BaseService<Client> {

    @Autowired
    private Validator validator;

    @Autowired
    private ClientRepository clientRepository;

    @Override
    public void update(long id, Client client) {
        var savedClient = super.read(id);
        savedClient.setStatus(client.getStatus());
    }

    @Override
    protected BaseRepository<Client> getRepository() {
        return clientRepository;
    }
}
