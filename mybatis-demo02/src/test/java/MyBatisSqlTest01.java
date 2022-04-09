import cn.agree.domain.QueryVo;
import cn.agree.domain.User;
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

public class MyBatisSqlTest01 {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testFindAll() {
        List<User> users = userMapper.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void saveUser() {
        User user = new User("方面", new Date(), "女","岳阳市");
        int i = userMapper.saveUser(user);
    }

    @Test
    public void testfindByVo() {
        User user = new User();
        user.setId(2);
        user.setUsername("李四");

        QueryVo queryVo = new QueryVo();
        queryVo.setUser(user);

        List<User> users = userMapper.findByVo(queryVo);

        for (User u : users) {
            System.out.println(u);
        }
    }


    @After
    public void destory() {
        sqlSession.commit();
        sqlSession.close();
    }
}
