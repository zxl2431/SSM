import cn.agree.domain.Account;
import cn.agree.domain.User;
import cn.agree.mapper.AccountMapper;
import cn.agree.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class LazyLoadTest01 {

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

    @After
    public void destory() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindAccountById() {
       /*Account account =*/
        Account account = accountMapper.getAccountById(58);
        System.out.println(account.getMoney());
        System.out.println("-----------------");
        System.out.println(account.getUser());
        // System.out.println(account);
    }

    @Test
    public void testFindAccounts() {
        List<Account> accounts = accountMapper.findAccounts();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindAllUser() {
        List<User> userList = userMapper.findUserList();
        for (User u : userList) {
            System.out.println(u);
        }

    }
}
