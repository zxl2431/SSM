import cn.agree.pojo.Account;
import cn.agree.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class AllAnnoTest03 {

    @Autowired
    private AccountService accountService;


    /**
     * 根据id查询
     * @return
     */
    @Test
    public void testFindById(){
        Integer accountId=4;
        Account account = accountService.findById(accountId);
        System.out.println(account);
    }

    /**
     * 查询所有
     * @return
     */
    @Test
    public void testFindAll(){
        List<Account> accounts = accountService.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }}
