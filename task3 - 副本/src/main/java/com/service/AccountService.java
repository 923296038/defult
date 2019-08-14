package com.service;

import com.pojo.Account;

import java.util.List;

public interface AccountService {
    int insertAccount(Account account);
    boolean deleteAccount(long id);
    boolean updateAccount(Account account);
    List<Account> findByName(String account_name);
    List<Account> findAllAccount();
}

