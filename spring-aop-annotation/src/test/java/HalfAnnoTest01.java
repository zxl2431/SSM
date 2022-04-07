import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HalfAnnoTest01 {
    private AccountService accountService;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean0.xml");
        accountService = (AccountService) ac.getBean("accountService");
    }

    @Test
    public void testAC() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean0.xml");

        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    @Test
    public void save() {
        accountService.saveAccount();
    }

    @Test
    public void delete() {
        accountService.deleteAccount();
    }

    @Test
    public void update() {
        accountService.updateAccount(1);
    }
}
