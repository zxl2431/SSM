package cn.agree.session;

import cn.agree.mapper.UserMapper;

import java.util.List;

public interface SqlSession {

    // UserMapper getMapper(Class<UserMapper> userMapperClass);

    /*
    *  改造成通用方法
    * */
    <T> T getMapper(Class<T> clazz);



    void close();
}
