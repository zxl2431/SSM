package cn.agree.web.servlet;

import cn.agree.domain.Role;
import cn.agree.mapper.RoleMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@WebServlet(name = "JNDIservlet", urlPatterns = "/jndi")
public class JNDIservlet extends HttpServlet{

    private RoleMapper roleMapper;
    private SqlSession session;
    private InputStream is;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet进入...");
        // 读取配置文件
        is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        session = sqlSessionFactory.openSession();
        roleMapper = session.getMapper(RoleMapper.class);

        List<Role> roleUserList = roleMapper.findRoleUserList();

        for (Role r : roleUserList) {
            System.out.println(r);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
