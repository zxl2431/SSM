package cn.agree.dao.impl;

import cn.agree.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("dao保存了账户");
    }
}
