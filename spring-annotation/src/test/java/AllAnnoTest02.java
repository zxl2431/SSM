import cn.agree.config.SpringConfiguration;
import cn.agree.pojo.Account;
import cn.agree.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AllAnnoTest02 {
    public static void main(String[] args) {
        /*
        *  这个就只在是读取xml的配置文件
        *  而是读取configuration的.class文件
        *  实现全注解配置
        *
        * */
        ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);

        AccountService accountService = (AccountService) ac.getBean("accountService");

        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);

    }
}
