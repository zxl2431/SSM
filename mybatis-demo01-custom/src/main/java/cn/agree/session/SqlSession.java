package cn.agree.session;

import cn.agree.mapper.UserMapper;

public interface SqlSession {

    UserMapper getMapper(Class<UserMapper> userMapperClass);

    void close();
}
