package cn.agree.mapper;

import cn.agree.domain.AccountCustomer;
import cn.agree.domain.Acct;

import java.util.List;

public interface AccountMapper {
    /*
    *  查询账户信息,同时还要展示用户信息
    *
    *  方式一
    * */
    List<AccountCustomer> findAccountList();

    /*
    *  查询账户信息
    *  方式二
    *
    * */
    List<Acct> findAcctList();

}
