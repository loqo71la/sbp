package dev.loqo71la.sbp.account.service;

import dev.loqo71la.sbp.account.model.Account;
import dev.loqo71la.sbp.account.repository.AccountRepository;
import dev.loqo71la.sbp.base.repository.BaseRepository;
import dev.loqo71la.sbp.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService extends BaseService<Account> {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    protected BaseRepository<Account> getRepository() {
        return accountRepository;
    }

    @Override
    public void update(long id, Account model) {

    }

//    @Autowired
//    private AccountRepository accountRepository;
//
//    @Autowired
//    private AccountMapper mapper;
//
//    public void create(AccountDto dto) {
//        validateAccountNumber(dto.accountNumber());
//        var account = mapper.toModel(dto);
//        accountRepository.save(account);
//    }
//
//    public AccountDto read(UUID id) {
//        return accountRepository.findById(id)
//                .map(mapper::toDto)
//                .orElseThrow(() -> new NotFoundException("id", id.toString()));
//    }
//
//    public void update(UUID id, AccountDto dto) {
//        var account = accountRepository.findById(id)
//                .orElseThrow(() -> new NotFoundException("id", id.toString()));
//        if (!account.getAccountNumber().equals(dto.accountNumber())) {
//            validateAccountNumber(dto.accountNumber());
//            account.setAccountNumber(dto.accountNumber());
//        }
//
//        account.setType(Account.AccountType.valueOfLabel(dto.type()));
//        account.setInitialBalance(dto.initialBalance());
//        account.setStatus(dto.status());
//        accountRepository.save(account);
//    }
//
//    public void delete(UUID id) {
//    }
//
//    private void validateAccountNumber(String value) {
//        if (accountRepository.existsByAccountNumber(value)) {
//            throw new AlreadyExistException("accountName", value);
//        }
//    }
}
