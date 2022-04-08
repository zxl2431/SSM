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

public class MyBatisTest01 {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init() {
        try {
            // 1,读取主配置文件(SqlMapConfig.xml)
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            // 2,创建builder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            // 3,构建工厂
            SqlSessionFactory sqlSessionFactory = builder.build(is);
            // 4,打开一个SqlSession
            sqlSession = sqlSessionFactory.openSession();
            // 5,通过SqlSession获取dao的代理类
            userMapper = sqlSession.getMapper(UserMapper.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void destroy() {
        sqlSession.commit();
        // 关闭资源
        sqlSession.close();
    }

    @Test
    public void testFindAll() throws IOException {
        List<User> users = userMapper.findAll();
        // 打印输出
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindOne() {
        User user = userMapper.findOne();
        System.out.println(user);
    }

    @Test
    public void testSaveUser() {
        User user = new User();
        user.setUsername("张十");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("武汉");

        int i = userMapper.saveUser(user);
        System.out.println("影响的行数:"+i);
        System.out.println("id:"+user.getId());

    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setUsername("张飞");
        user.setSex("男");
        user.setBirthday(new Date());
        user.setAddress("天津");
        user.setId(1);
        userMapper.updateUser(user);
    }

    @Test
    public void testDeleteUser() {
        userMapper.deleteUser(65);
    }

    @Test
    public void testFindUserByUsername() {
        String name="%张%";
        List<User> users = userMapper.findUserByUsername(name);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindUserByUsername1() {
        String name="张";
        List<User> users = userMapper.findUserByUsername(name);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
