package dev.loqo71la.bp.service;

import dev.loqo71la.bp.common.contant.DtoConstant;
import dev.loqo71la.bp.common.exception.AlreadyExistException;
import dev.loqo71la.bp.common.exception.NotFoundException;
import dev.loqo71la.bp.dto.AccountDto;
import dev.loqo71la.bp.mapper.AccountMapper;
import dev.loqo71la.bp.model.AccountType;
import dev.loqo71la.bp.repository.AccountRepository;
import dev.loqo71la.bp.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AccountService implements CrudService<AccountDto> {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AccountMapper mapper;

    @Override
    public void create(AccountDto dto) {
        validateAccountNumber(dto.accountNumber());
        var client = clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new NotFoundException(DtoConstant.CLIENT_ID, dto.clientId().toString()));
        var account = mapper.toModel(dto);
        account.setClient(client);
        accountRepository.save(account);
    }

    @Override
    public Page<AccountDto> readAll(Pageable pageable) {
        return accountRepository.findAll(pageable)
                .map(mapper::toDto);
    }

    @Override
    public AccountDto read(UUID id) {
        return accountRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException(DtoConstant.ID, id.toString()));
    }

    @Override
    public void update(UUID id, AccountDto dto) {
        var account = accountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(DtoConstant.ID, id.toString()));
        if (!account.getAccountNumber().equals(dto.accountNumber())) {
            validateAccountNumber(dto.accountNumber());
            account.setAccountNumber(dto.accountNumber());
        }
        if (!account.getClient().getId().equals(dto.clientId())) {
            var client = clientRepository.findById(dto.clientId())
                    .orElseThrow(() -> new NotFoundException(DtoConstant.CLIENT_ID, dto.clientId().toString()));
            account.setClient(client);
        }

        account.setType(AccountType.valueOfLabel(dto.type()));
        account.setInitialBalance(dto.initialBalance());
        account.setStatus(dto.status());
        accountRepository.save(account);
    }

    @Override
    public void delete(UUID id) {
        accountRepository.findById(id)
                .ifPresent(account -> {
                    var client = account.getClient();
                    client.getAccountList().remove(account);

                    clientRepository.save(client);
                    accountRepository.delete(account);
                });
    }

    private void validateAccountNumber(String value) {
        if (accountRepository.existsByAccountNumber(value)) {
            throw new AlreadyExistException(DtoConstant.ACCOUNT_NUMBER, value);
        }
    }
}
