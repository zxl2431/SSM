package cn.agree.mapper;

import cn.agree.domain.Account;
import cn.agree.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountMapper {

    @Select(value = "select * from account1")
    @Results({
            @Result(property = "user", column = "uid",
            one = @One(select = "cn.agree.mapper.UserMapper.findByUserId",
                    fetchType = FetchType.LAZY))
    })
    List<Account> findAll();

    @Select(value = "select * from account1 where uid=#{uid}")
    List<Account> findAccountListByUid(Integer uid);

}
