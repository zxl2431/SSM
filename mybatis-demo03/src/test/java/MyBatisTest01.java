import cn.agree.domain.Role;
import cn.agree.domain.User;
import cn.agree.mapper.RoleMapper;
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

public class MyBatisTest01 {

    private SqlSession sqlSession;
    private RoleMapper roleMapper;
    private UserMapper userMapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sessionFactory = builder.build(is);
        sqlSession = sessionFactory.openSession();
        roleMapper = sqlSession.getMapper(RoleMapper.class);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void testFindRoleUserList() {
        List<Role> roleUserList = roleMapper.findRoleUserList();

        for (Role r : roleUserList) {
            System.out.println(r);
        }
    }

    @Test
    public void testFindUserRoleList() {
        List<User> userRoleList = userMapper.findUserRole();

        for (User u : userRoleList) {
            System.out.println(u);
        }

    }

}
