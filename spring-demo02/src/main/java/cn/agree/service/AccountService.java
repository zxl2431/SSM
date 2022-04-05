package cn.agree.service;

import cn.agree.dao.AccountDao;
import cn.agree.pojo.Account;

import java.util.List;

public class AccountService {

    private AccountDao accountDao;

    public void save(Account account) {
        accountDao.save(account);
    }

    public void update(Account account) {
        accountDao.update(account);
    }

    public void delete(Integer accountId) {
        accountDao.delete(accountId);
    }

    public Account findById(Integer accountId) {
        return accountDao.findById(accountId);
    }

    public List<Account> findAll() {
        return accountDao.findAll();
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }
}
