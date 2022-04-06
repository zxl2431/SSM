package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.pojo.Account;
import cn.agree.service.AccountService;

import java.util.List;

public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    /*
    *  整个set方法
    *
    * */

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer accountId) {
        accountDao.deleteAccount(accountId);
    }

    @Override
    public Account findAccountById(Integer accountId) {
        return accountDao.findAccountById(accountId);
    }

    @Override
    public List<Account> findAllAccount() {
        return accountDao.findAllAccount();
    }

    @Override
    public void transfer(String sourceName, String targetName, double money) {
        // 根据名称查询两个账户信息
        Account source = accountDao.findByName(sourceName);
        Account target = accountDao.findByName(targetName);
        // 转出账户减钱,转入账户价钱
        source.setBalance(source.getBalance()-money);
        target.setBalance(target.getBalance()+money);
        // 更新两个账户
        accountDao.updateAccount(source);
        accountDao.updateAccount(target);
    }
}
