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

public class MyBatisTest02 {

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


    /*
    *  包装类作为参数
    * */
    @Test
    public void testQueryVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("张飞");
        vo.setUser(user);
        User userInfo = userMapper.findByVo(vo);
        System.out.println(userInfo);
    }

    @Test
    public void testCount() {
        int userCount = userMapper.findUserCount();
        System.out.println(userCount);
    }
}
