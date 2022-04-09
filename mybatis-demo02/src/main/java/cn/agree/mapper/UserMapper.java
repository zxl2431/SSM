package cn.agree.mapper;


import cn.agree.domain.QueryVo;
import cn.agree.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();
    User findOne();
    int saveUser(User user);
    int updateUser(User user);
    int deleteUser(Integer id);
    /*
    *  模糊查询
    * */
    List<User> findUserByUsername(String username);

    User findByVo(QueryVo vo);

    int findUserCount();
}
