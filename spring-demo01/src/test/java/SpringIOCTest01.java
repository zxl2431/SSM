import cn.agree.dao.AccountDao;
import cn.agree.service.AccountService;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

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

    /*
    *  ApplicationContext: 只要一读取配置文件,默认情况下就会创建对象
    *  BeanFactory: 什么时候使用什么时候创建
    *
    * */
    @Test
    public void testApplicationContext() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        int count = ac.getBeanDefinitionCount();
        System.out.println(count);

    }

    @Test
    public void testBeanFactory() {
        // 读取resource
        Resource resource = new ClassPathResource("bean.xml");

        // 创建BeanFactory对象
        BeanFactory beanFactory = new XmlBeanFactory(resource);

        // 获取实例 此时才会创建bean
        AccountService accountService = (AccountService) beanFactory.getBean("accountService");
    }

    @Test
    public void testBeanAttribute() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        System.out.println(accountService);
        AccountDao accountDao = (AccountDao) ac.getBean("accountDao");
        System.out.println(accountDao);
    }

}
