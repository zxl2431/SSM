package cn.agree.dao;

import cn.agree.pojo.Account;

public interface AccountDao {

    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);

    /**
     * 根据名称查询账户信息
     * @return
     */
    Account findAccountByName(String name);

    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);
}
