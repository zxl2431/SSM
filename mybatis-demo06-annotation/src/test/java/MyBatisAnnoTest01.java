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
import java.util.Date;
import java.util.List;

public class MyBatisAnnoTest01 {

    private UserMapper userMapper;
    private AccountMapper accountMapper;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private InputStream is;

    @Before
    public void init() throws IOException {
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession();

        userMapper = sqlSession.getMapper(UserMapper.class);
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @After
    public void destory() {
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testFindById() {
        User user = userMapper.findByUserId(2);
        System.out.println(user);
    }

    @Test
    public void testFindByName() {
        List<User> users = userMapper.findUserListByName("王");
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testUpdateById() {
        User user = new User(2, "改一下", new Date(), "女", "广西南宁" );

        userMapper.updateUserByUserId(user);
    }


    @Test
    public void testAccountAll() {
        List<Account> accounts = accountMapper.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

}
