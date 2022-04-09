package cn.agree.mapper;

import cn.agree.domain.AccountCustomer;

import java.util.List;

public interface AccountMapper {
    /*
    *  查询账户信息,同时还要展示用户信息
    * */
    List<AccountCustomer> findAccountList();


}
