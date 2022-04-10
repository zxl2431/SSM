package cn.agree.mapper;

import cn.agree.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface UserMapper {

    /*
    *  根据ID查询用户
    *
    * */
    @Select("select * from user where id=#{userid}")
    User findByUserId(Integer userid);

    /*
    *  根据名字模糊查询
    *
    * */
    @Select(value = "select * from user where username like '%${value}%' ")
    List<User> findUserListByName(String name);

    /*
    * 查询所有
    *
    * */
    /*@Select(value = "select user.id uid, user.username uname from user")
    @Results(id = "UserResultMap", value = {
            @Result(id = true, column = "uid", property = "id"),
            @Result(column = "uid", property = "id"),
            @Result(column = "uname", property = "username")
    })*/
    @Select(value = "select * from user")
    @Results(
            @Result(property = "accList", column = "id",
                many = @Many(select = "cn.agree.mapper.AccountMapper.findAccountListByUid",
                fetchType = FetchType.LAZY)
            )
    )
    List<User> findAll();

    /*
    *  根据ID修改用户信息
    *
    * */
    @Update(value = "update user set username=#{username}, sex=#{sex} where id=#{id}")
    int updateUserByUserId(User user);

    /*
    *  根据ID删除用户
    *
    * */
    @Delete(value= "delete from user where id=#{id}")
    int deleteByUserId(int i);

    /*
    *  查询数据条数
    *
    * */
    @Select("select count(*) from user")
    int findCount();

}
