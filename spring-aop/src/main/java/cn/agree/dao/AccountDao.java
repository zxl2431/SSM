package cn.agree.dao;

import cn.agree.pojo.Account;

import java.util.List;

public interface AccountDao {
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
    Account findAccountById(Integer accountId);
    List<Account> findAllAccount();

    Account findByName(String name);
}
