package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;
import cn.agree.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    private QueryRunner runner;

    /*
    * 整一个set方法去配置xml
    *
    * */
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public void saveAccount(Account account) {
        try {
            runner.update("insert into account(name,balance)values(?,?)",account.getName(),account.getBalance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            runner.update("update account set name=?,balance=? where id=?",account.getName(),account.getBalance(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer accountId) {
        try {
            runner.update("delete from account where id=?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account findAccountById(Integer accountId) {
        try {
            return runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public List<Account> findAllAccount() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    @Override
    public Account findByName(String name) {
        try {
            return runner.query("select * from account where name=?",new BeanHandler<Account>(Account.class),name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
