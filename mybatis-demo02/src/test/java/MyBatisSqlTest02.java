import cn.agree.domain.AccountCustomer;
import cn.agree.domain.Acct;
import cn.agree.domain.User;
import cn.agree.mapper.AccountMapper;
import cn.agree.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisSqlTest02 {

    private SqlSession sqlSession;
    private AccountMapper accountMapper;
    private UserMapper userMapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession();
        accountMapper = sqlSession.getMapper(AccountMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testfindAccountList() {
        List<AccountCustomer> accountCustomers = accountMapper.findAccountList();
        for (AccountCustomer ac : accountCustomers) {
            System.out.println(ac);
        }
    }

    @Test
    public void testfindAcctList() {
        List<Acct> acctList = accountMapper.findAcctList();
        for (Acct acct : acctList) {
            System.out.println(acct);
        }
    }

    /*
    *  一个用户多个账号
    * */
    @Test
    public void testUserAccounts() {
        List<User> userAccountList = userMapper.findUserAccountList();

        for (User u : userAccountList) {
            System.out.println(u);
        }
    }
}
