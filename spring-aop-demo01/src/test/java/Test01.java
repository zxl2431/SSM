import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    private AccountService accountService;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean0.xml");
        accountService = (AccountService) ac.getBean("accountService");
    }

    @Test
    public void save(){
        accountService.saveAccount();
    }
}
