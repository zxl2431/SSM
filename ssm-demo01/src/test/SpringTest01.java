import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest01 {

    private  AccountService accountService;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        accountService = ac.getBean(AccountService.class);
    }

    @Test
    public void testFindAll() {
        // accountService.saveAccount();
        accountService.findAll();
    }

}
