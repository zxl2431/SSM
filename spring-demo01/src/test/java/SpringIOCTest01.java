import cn.agree.dao.AccountDao;
import cn.agree.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIOCTest01 {
    public static void main(String[] args) {
        // 1 使用ApplicationContext接口 获取spring容器
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        System.out.println(accountService);
        // AccountDao accountDao = (AccountDao) ac.getBean("accountDao");
        // System.out.println(accountDao);
        System.out.println("--------------------");

        accountService.saveAccount();
        // accountDao.saveAccount();


    }

}
