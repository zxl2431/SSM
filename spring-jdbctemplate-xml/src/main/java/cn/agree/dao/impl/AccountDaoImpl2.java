package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;
import cn.agree.pojo.Account;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/*
*  JdbcDaoSupport是Spring框架为我们提供的一个抽象类
*  该类定义了一个JdbcTemplate对象
*  可以直接获取使用,只需要提供一个数据源
*
* */
public class AccountDaoImpl2 extends JdbcDaoSupport implements AccountDao {

    @Override
    public Account findAccountById(Integer id) {
        List<Account> accounts = getJdbcTemplate().query("select * from account where id=?", new BeanPropertyRowMapper<Account>(Account.class), id);

        return accounts.isEmpty()?null:accounts.get(0);
    }


    @Override
    public Account findAccountByName(String name) {
        List<Account> list = getJdbcTemplate().query("select * from account where name=?", new BeanPropertyRowMapper<Account>(Account.class), name);
        if (list.isEmpty()) {
            return null;
        }
        if (list.size() > 1) {
            throw new RuntimeException("结果集不唯一,不是只有一个账户对象");
        }
        return list.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        getJdbcTemplate().update("update account set balance = ? where id =?", account.getBalance(), account.getId());
    }
}
