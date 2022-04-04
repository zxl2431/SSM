package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.dao.impl.AccountDaoImpl;
import cn.agree.service.AccountService;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    @Override
    public void saveAccount() {
        System.out.println("service层保存账户...");
        accountDao.saveAccount();
    }

}
