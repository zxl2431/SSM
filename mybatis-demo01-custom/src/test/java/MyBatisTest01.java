import cn.agree.domain.User;
import cn.agree.io.Resources;
import cn.agree.mapper.UserMapper;
import cn.agree.session.SqlSession;
import cn.agree.session.SqlSessionFactory;
import cn.agree.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisTest01 {

    @Test
    public void testFindAll() throws IOException {
        // 读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        // System.out.println(is);

        // 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        // 通过SqlSessionFactoryBuilder对象构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = builder.build(is);

        // SqlSessionFactory构建一个SqlSession
        SqlSession session = sqlSessionFactory.openSession();

        // 通过SqlSession来实现增删改查
        UserMapper userMapper = session.getMapper(UserMapper.class);
       /* List<User> users = userMapper.findAll();

        // 打印输出
        for (User user : users) {
            System.out.println(user);
        }

        // 关闭资源
        session.close();
        is.close();*/

    }


}
