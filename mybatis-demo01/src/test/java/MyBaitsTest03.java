import cn.agree.dao.UserDao;
import cn.agree.dao.impl.UserDaoImpl;
import cn.agree.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MyBaitsTest03 {

    private UserDao userDao;

    @Before
    public void init() {
        try {
            //1.读取主配置文件(SqlMapConfig.xml)，获取配置文件的字节输入流
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

            //2.创建一个SqlSessionFactoryBuilder对象
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

            //3.构建SqlSessionFactory(会话工厂对象)
            SqlSessionFactory sqlSessionFactory = builder.build(is);

            //创建UserDao的实现类实例,并将SqlSessionFactory传递过去
            userDao = new UserDaoImpl(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindByUserId() {
        User user = userDao.findByUserId(1);
        System.out.println(user);
    }

    /***
     * 根据名字模糊查询
     */
    @Test
    public void testFindUserByUsername(){
        List<User> users = userDao.findUserByUsername("%王%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /***
     * 添加用户
     */
    @Test
    public void testSaveUser(){
        //创建User实例
        User user = new User();
        user.setUsername("东方不败");
        user.setAddress("深圳市");
        user.setBirthday(new Date());
        user.setSex("男");

        //调用添加方法保存数据
        int i = userDao.saveUser(user);
        System.out.println("保存的id:"+user.getId());

    }

}
