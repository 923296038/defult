package com.mapper;

import com.pojo.Account;
import java.util.List;

public interface AccountMapper {
    int insertAccount(Account account);
    boolean deleteAccount(long id);
    boolean updateAccount(Account account);
    List<Account> findByName(String account_name);
    List<Account> findAllAccount();
}
