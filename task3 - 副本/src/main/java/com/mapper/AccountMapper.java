package com.mapper;

import com.pojo.Account;
import java.util.List;

public interface AccountMapper {
    int insertAccount(Account account);
    boolean deleteAccount(long id);
    boolean updateAccount(Account account);
    Account findById(Long id);
    List<Account> findByRole(String role);
    List<Account> findByName(String account_name);
    List<Account> findAllAccount();
}
