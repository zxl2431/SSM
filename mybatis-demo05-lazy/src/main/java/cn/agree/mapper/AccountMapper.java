package cn.agree.mapper;

import cn.agree.domain.Account;


import java.util.List;


public interface AccountMapper {

    /*
    *  根据ID查询账户信息
    *
    * */
    Account getAccountById(int i);

    /*
    *  查询所有账户信息
    *
    * */
    List<Account> findAccounts();


}
