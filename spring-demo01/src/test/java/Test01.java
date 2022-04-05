import cn.agree.dao.AccountDao;
import cn.agree.factory.BeanFactory;
import cn.agree.service.AccountService;
import cn.agree.service.impl.AccountServiceImpl;

public class Test01 {
    public static void main(String[] args) {
        test01();
        // AccountService accountService = new AccountServiceImpl();
        AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
        AccountDao accountDao = (AccountDao) BeanFactory.getBean("accountDao");

        // accountService.saveAccount();
        accountDao.saveAccount();


    }

    public static void test01() {
        BeanFactory.printBean();
    }
}
