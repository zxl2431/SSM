package cn.agree.factory;

import cn.agree.manager.TransactionManager;
import cn.agree.service.AccountService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class BeanFactory {
    // 注入txManager对象
    private TransactionManager txManager;
    // 注入accountService对象
    private AccountService accountService;

    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    /*
    *  通过工厂创建AccountService的代理类
    *
    * */
    public AccountService createAccountService() {
        AccountService accountServiceProxy = (AccountService) Proxy.newProxyInstance(
                AccountService.class.getClassLoader(),
                new Class[]{AccountService.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;
                        try {
                            //开启事务
                            txManager.beginTransaction();

                            //真实方法被调用
                            result = method.invoke(accountService, args);

                            //提交事务
                            txManager.commit();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();

                            //事务回滚
                            txManager.rollback();
                        }finally {
                            //关闭资源
                            txManager.release();
                        }
                        return result;
                    }
                }
        );
        return  accountServiceProxy;
    }



}
