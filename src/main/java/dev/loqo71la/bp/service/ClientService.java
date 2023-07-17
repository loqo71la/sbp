package dev.loqo71la.bp.service;

import dev.loqo71la.bp.common.contant.DtoConstant;
import dev.loqo71la.bp.common.exception.AlreadyExistException;
import dev.loqo71la.bp.common.exception.NotFoundException;
import dev.loqo71la.bp.dto.ClientDto;
import dev.loqo71la.bp.mapper.ClientMapper;
import dev.loqo71la.bp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClientService implements CrudService<ClientDto> {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper mapper;

    @Override
    public void create(ClientDto dto) {
        validateFullName(dto.fullName());
        var client = mapper.toModel(dto);
        clientRepository.save(client);
    }

    @Override
    public Page<ClientDto> readAll(Pageable pageable) {
        return clientRepository.findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    public ClientDto read(UUID id) {
        return clientRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException(DtoConstant.ID, id.toString()));
    }

    @Override
    public void update(UUID id, ClientDto dto) {
        var client = clientRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(DtoConstant.ID, id.toString()));
        if (!client.getFullName().equals(dto.fullName())) {
            validateFullName(dto.fullName());
            client.setFullName(dto.fullName());
        }
        client.setAddress(dto.address());
        client.setPhone(dto.phone());
        client.setPassword(dto.password());
        client.setStatus(dto.status());
        clientRepository.save(client);
    }

    @Override
    public void delete(UUID id) {
        clientRepository.deleteById(id);
    }

    private void validateFullName(String value) {
        if (clientRepository.existsByFullName(value)) {
            throw new AlreadyExistException(DtoConstant.FULL_NAME, value);
        }
    }
}
