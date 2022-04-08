package cn.agree.dao;

import cn.agree.domain.User;

import java.util.List;

public interface UserDao {


    /**
     * 根据ID查找
     * @param id
     * @return
     */
    User findByUserId(Integer id);

    /**
     * 根据姓名模糊查询
     * @param username
     * @return
     */
    List<User> findUserByUsername(String username);

    /***
     * 保存用户
     * @param user
     * @return
     */
    int saveUser(User user);

}
