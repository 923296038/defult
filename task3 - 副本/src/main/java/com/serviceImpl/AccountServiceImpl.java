package com.serviceImpl;

import com.mapper.AccountMapper;
import com.pojo.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public int insertAccount(Account account) {
        accountMapper.insertAccount(account);
        return accountMapper.getId(account.getAccount_name());
    }

    @Override
    public boolean deleteAccount(long id) {
        return accountMapper.deleteAccount(id);
    }

    @Override
    public boolean updateAccount(Account account) {
        return accountMapper.updateAccount(account);
    }

    @Override
    public Account findById(Long id) {
        return accountMapper.findById(id);
    }

    @Override
    public List<Account> findByRole(String role) {
        return accountMapper.findByRole(role);
    }

    @Override
    public List<Account> findByName(String account_name) {
        return accountMapper.findByName(account_name);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountMapper.findAllAccount();
    }
}
