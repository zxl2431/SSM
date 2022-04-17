package cn.agree.service;

import cn.agree.domain.Account;

import java.util.List;

public interface AccountService {

    /*
    *  保存账号
    *
    * */
    void saveAccount(Account account);

    /*
    *  查询所有
    *
    * */
    List<Account> findAll();
}

