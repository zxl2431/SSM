import cn.agree.dao.AccountDao;
import cn.agree.pojo.Account;
import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TransferTest01 {

    private AccountService accountService;
    private AccountDao accountDao;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        accountService = (AccountService) ac.getBean("accountService");
        accountDao = (AccountDao) ac.getBean("accountDao");
    }


    @Test
    public void findAll() {
        List<Account> accounts = accountService.findAllAccount();
        System.out.println(accounts);
    }

    @Test
    public void updateAccount() {
        Account account = new Account();

        accountService.updateAccount(account);
    }

    /*
    *
    * */
    @Test
    public void findByName() {
        Account account = accountDao.findByName("张三");
        System.out.println(account);
    }

    /*
    *  测试一下转账
    *
    * */
    @Test
    public void transfer() {
        accountService.transfer("李四", "张三", 100);
    }

}
