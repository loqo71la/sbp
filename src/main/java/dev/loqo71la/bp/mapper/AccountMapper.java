package dev.loqo71la.bp.mapper;

import dev.loqo71la.bp.dto.AccountDto;
import dev.loqo71la.bp.model.Account;
import dev.loqo71la.bp.model.AccountType;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper implements Mapper<AccountDto, Account> {

    @Override
    public AccountDto toDto(Account model) {
        return new AccountDto(
                model.getId(),
                model.getAccountNumber(),
                model.getType().getLabel(),
                model.getInitialBalance(),
                model.isStatus(),
                model.getClient().getId()
        );
    }

    @Override
    public Account toModel(AccountDto dto) {
        var model = new Account();
        model.setAccountNumber(dto.accountNumber());
        model.setType(AccountType.valueOfLabel(dto.type()));
        model.setInitialBalance(dto.initialBalance());
        model.setStatus(dto.status());
        return model;
    }
}
