package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.dao.impl.AccountDaoImpl;
import cn.agree.factory.BeanFactory;
import cn.agree.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {

    private String name;
    private Integer age;
    private Date birthday;

    /*
     *  无参构造方法
     * */
    public AccountServiceImpl() {
        System.out.println("创建AccountServiceImpl...");
    }

    /*
    *  有参构造
    *
    * */
    public AccountServiceImpl(String name, Integer age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public AccountServiceImpl(String name, String age) {
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
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
