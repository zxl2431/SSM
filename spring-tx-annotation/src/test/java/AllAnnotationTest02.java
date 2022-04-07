import cn.agree.config.SpringConfiguration;
import cn.agree.service.AccountService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AllAnnotationTest02 {

    private AccountService accountService;

    @Before
    public void init() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        accountService = (AccountService) ac.getBean("accountService");
    }

    @Test
    public void transTest01() {
        accountService.transfer("张三", "李四", 20);
    }


}
