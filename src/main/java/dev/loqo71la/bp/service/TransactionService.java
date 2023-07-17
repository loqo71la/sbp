package dev.loqo71la.bp.service;

import dev.loqo71la.bp.common.contant.DtoConstant;
import dev.loqo71la.bp.common.contant.ResponseConstant;
import dev.loqo71la.bp.common.exception.BadRequestException;
import dev.loqo71la.bp.common.exception.NotFoundException;
import dev.loqo71la.bp.dto.TransactionDto;
import dev.loqo71la.bp.mapper.TransactionMapper;
import dev.loqo71la.bp.model.TransactionType;
import dev.loqo71la.bp.repository.AccountRepository;
import dev.loqo71la.bp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransactionService implements CrudService<TransactionDto> {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionMapper mapper;

    @Override
    public void create(TransactionDto dto) {
        var account = accountRepository.findById(dto.accountId())
                .orElseThrow(() -> new NotFoundException(DtoConstant.ACCOUNT_ID, dto.accountId().toString()));

        var transaction = mapper.toModel(dto);
        transaction.setAccount(account);
        transactionRepository.save(transaction);
    }

    @Override
    public Page<TransactionDto> readAll(Pageable pageable) {
        return transactionRepository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public TransactionDto read(UUID id) {
        return transactionRepository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NotFoundException(DtoConstant.ID, id.toString()));
    }

    @Override
    public void update(UUID id, TransactionDto dto) {
        var transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(DtoConstant.ID, id.toString()));
        if (!transaction.getAccount().getId().equals(dto.accountId())) {
            var account = accountRepository.findById(dto.accountId())
                    .orElseThrow(() -> new NotFoundException(DtoConstant.ACCOUNT_ID, dto.accountId().toString()));
            transaction.setAccount(account);
        }

        transaction.setType(TransactionType.valueOfLabel(dto.type()));
        transaction.setValue(dto.value());
        transactionRepository.save(transaction);
    }

    @Override
    public void delete(UUID id) {
        transactionRepository.findById(id)
                .ifPresent(transaction -> {
                    var account = transaction.getAccount();
                    account.getTransactionList().remove(transaction);

                    accountRepository.save(account);
                    transactionRepository.delete(transaction);
                });
    }
}
