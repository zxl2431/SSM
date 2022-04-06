import cn.agree.pojo.Account;
import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TransferTest03 {
    private AccountService accountService;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");
        accountService = (AccountService) ac.getBean("accountServiceProxy");
        System.out.println(accountService);
    }

    @Test
    public void testAC() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean2.xml");

        for (String name: ac.getBeanDefinitionNames()) {
            System.out.println(name);
        }

        System.out.println("------------");
        System.out.println(ac.getBean("accountServiceProxy"));
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
