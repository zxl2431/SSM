package cn.agree.dao.impl;

import cn.agree.dao.UserDao;
import cn.agree.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {
    /*
    *  将SqlSessionFactory设置成为成员变量
    *  通过它来获取SqlSession
    *
    * */
    private SqlSessionFactory sqlSessionFactory;

    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Override
    public User findByUserId(Integer id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("test.findByUserId", id);
        return user;
    }

    @Override
    public List<User> findUserByUsername(String username) {

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("test.findUserByUsername", username);
        return users;
    }

    @Override
    public int saveUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        int account = sqlSession.insert("test.saveUser", user);
        sqlSession.commit();
        return account;
    }
}
