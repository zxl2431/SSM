package cn.agree.dao;

import cn.agree.domain.Account;

import java.util.List;

public interface AccountDao {

    /*
    *  保存账号
    *
    * */
    int saveAccount(Account account);

    /*
    *  查询所有
    *
    * */
    List<Account> findAll();
}
