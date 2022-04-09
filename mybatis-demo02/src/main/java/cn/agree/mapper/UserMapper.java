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
    *  按username和id有就加条件
    * */
    List<User> findUserByUsername(String username);

    /*
    *  根据ID集合查询
    *
    * */
    List<User> findByRang(QueryVo queryVo);

    List<User> findByVo(QueryVo vo);

    int findUserCount();

    /*
    *  查询用户信息,包含账户集合信息
    *
    * */
    List<User> findUserAccountList();

}
