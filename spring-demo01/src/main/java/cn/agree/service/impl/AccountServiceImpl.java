package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.dao.impl.AccountDaoImpl;
import cn.agree.factory.BeanFactory;
import cn.agree.service.AccountService;

public class AccountServiceImpl implements AccountService {

    // private AccountDao accountDao = new AccountDaoImpl();
    // private  AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

    /*
    *  无参构造方法
    * */
    public AccountServiceImpl() {
        System.out.println("创建AccountServiceImpl...");
    }

    /*
    *  bean的作用和生命周期
    *  init()
    *  destory()
    * */
    public void init() {
        System.out.println("AccountServiceImpl初始化了...");
    }

    public void destory() {
        System.out.println("AccountServiceImpl销毁了...");
    }


    @Override
    public void saveAccount() {

        System.out.println("service层保存账户...");
        // BeanFactory.printBean();
        // accountDao.saveAccount();
    }

}
