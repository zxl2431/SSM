package cn.agree.dao;

import cn.agree.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {

    /*
    *  保存账号
    *
    * */
    @Insert("insert into account(name,money) values(#{name}, #{money})")
    int saveAccount(Account account);

    /*
    *  查询所有
    *
    * */
    @Select("select * from account")
    List<Account> findAll();
}
