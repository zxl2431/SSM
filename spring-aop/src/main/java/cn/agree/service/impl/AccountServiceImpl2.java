package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.manager.TransactionManager;
import cn.agree.pojo.Account;
import cn.agree.service.AccountService;

import java.util.List;

public class AccountServiceImpl2 implements AccountService {

    private AccountDao accountDao;
    private TransactionManager txManager;
    /*
     *  整个set方法
     *
     * */
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            accountDao.saveAccount(account);
            //提交事务
            txManager.commit();
        }catch(Exception e) {
            //回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放资源
            txManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //开启事务
            txManager.beginTransaction();
            accountDao.updateAccount(account);
            //提交事务
            txManager.commit();
        }catch(Exception e) {
            //回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放资源
            txManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            //开启事务
            txManager.beginTransaction();
            accountDao.deleteAccount(accountId);
            //提交事务
            txManager.commit();
        }catch(Exception e) {
            //回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放资源
            txManager.release();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            //开启事务
            txManager.beginTransaction();
            Account account = accountDao.findAccountById(accountId);
            //提交事务
            txManager.commit();
            return account;
        }catch(Exception e) {
            //回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放资源
            txManager.release();
        }
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            //开启事务
            txManager.beginTransaction();
            List<Account> accounts = accountDao.findAllAccount();
            //提交事务
            txManager.commit();
            return accounts;
        }catch(Exception e) {
            //回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放资源
            txManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, double money) {
        try {
            //开启事务
            txManager.beginTransaction();

            //1.根据名称查询转出账户
            Account source = accountDao.findByName(sourceName);
            //2.根据名称查询转入账户
            Account target = accountDao.findByName(targetName);
            //3.转出账户减钱
            source.setBalance(source.getBalance()-money);
            //4.转入账户加钱
            target.setBalance(target.getBalance()+money);
            //5.更新转出账户
            accountDao.updateAccount(source);
            //模拟转账异常
            int i=1/0;
            //6.更新转入账户
            accountDao.updateAccount(target);

            //提交事务
            txManager.commit();
        }catch(Exception e) {
            //回滚事务
            txManager.rollback();
            throw new RuntimeException(e);
        }finally {
            //释放资源
            txManager.release();
        }
    }
}
