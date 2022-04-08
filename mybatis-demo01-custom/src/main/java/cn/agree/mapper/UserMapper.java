package cn.agree.mapper;



import cn.agree.domain.User;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    User findOne();
}
