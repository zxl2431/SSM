package cn.agree.mapper;


import cn.agree.domain.User;

import java.util.List;

public interface UserMapper {

    /*
    *  查询用户列表
    *
    * */
    List<User> findUserList();
}
