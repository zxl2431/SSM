package cn.agree.service;

import cn.agree.pojo.Account;

public interface AccountService {

    /**
     * 根据id查询账户信息
     * @param id
     * @return
     */
    Account findAccountById(Integer id);//查

    /**
     * 转账
     * @param sourceName	转出账户名称
     * @param targeName		转入账户名称
     * @param money			转账金额
     */
    void transfer(String sourceName, String targeName, double money);
}
