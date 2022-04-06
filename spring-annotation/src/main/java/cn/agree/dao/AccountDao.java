package cn.agree.dao;

import cn.agree.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;


/*
*  当使用注解时, set方法不用写
*
* */
// @Component("accountDao")
@Repository("accountDao")
public class AccountDao {

    @Autowired
    private QueryRunner runner;

    /*
     *  保存操作
     * */
    public void save(Account account) {
        try {
            runner.update("insert into account(name,balance)values(?,?)",account.getName(),account.getBalance());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /***
     * 修改操作
     * @param account
     */
    public void update(Account account) {
        try {
            runner.update("update account set name=?,balance=? where id=?",account.getName(),account.getBalance(),account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 删除操作
     * @param accountId
     */
    public void delete(Integer accountId) {
        try {
            runner.update("delete from account where id=?",accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 根据ID查询
     * @param accountId
     * @return
     */
    public Account findById(Integer accountId) {
        try {
            return runner.query("select * from account where id=?",new BeanHandler<Account>(Account.class),accountId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /***
     * 查询所有
     * @return
     */
    public List<Account> findAll() {
        try {
            return runner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }

    /***
     * 注入QueryRunner对象
     * @param runner
     */
    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }


}
