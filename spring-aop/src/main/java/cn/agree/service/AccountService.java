package cn.agree.service;

import cn.agree.pojo.Account;

import java.util.List;

public interface AccountService {
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccount(Integer accountId);
    Account findAccountById(Integer accountId);
    List<Account> findAllAccount();

    void transfer(String sourceName, String targetName, double money);

}
