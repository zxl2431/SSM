import cn.agree.dao.AccountDao;
import cn.agree.pojo.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JTDao2Test {
    private AccountDao accountDao;

    @Before
    public void init() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean0.xml");
        accountDao = (AccountDao) ac.getBean("accountDao2");
    }

    @Test
    public void allBean() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean0.xml");
        for (String name : ac.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }

    @Test
    public void findAccountById() {
        Account account = accountDao.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void findAccountByName() {
        Account account = accountDao.findAccountByName("王五");
        System.out.println(account);
    }
}
