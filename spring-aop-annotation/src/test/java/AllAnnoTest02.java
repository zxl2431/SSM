import cn.agree.config.SpringConfiguration;
import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllAnnoTest02 {

    private AccountService accountService;

    @Before
    public void init() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        accountService = (AccountService) ac.getBean("accountService");
    }

    @Test
    public void save() {
        accountService.saveAccount();
    }

    @Test
    public void delete() {
        accountService.deleteAccount();
    }
}
