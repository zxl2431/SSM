package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.dao.impl.AccountDaoImpl;
import cn.agree.factory.BeanFactory;
import cn.agree.service.AccountService;

public class AccountServiceImpl implements AccountService {

    // private AccountDao accountDao = new AccountDaoImpl();
    private  AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");


    @Override
    public void saveAccount() {

        System.out.println("service层保存账户..."+accountDao);
        // BeanFactory.printBean();
        accountDao.saveAccount();
    }

}
