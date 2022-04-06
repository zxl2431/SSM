import cn.agree.pojo.Account;
import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TransferTest02 {

    private  AccountService accountService;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean1.xml");
        accountService = (AccountService) ac.getBean("accountService");
    }

    @Test
    public void findAll() {
        List<Account> accounts = accountService.findAllAccount();
        System.out.println(accounts);
    }

    /*
     *  测试一下转账
     *
     * */
    @Test
    public void transfer() {
        accountService.transfer("李四", "张三", 10);
    }
}
