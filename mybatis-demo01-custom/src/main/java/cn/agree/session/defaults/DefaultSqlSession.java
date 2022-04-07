package cn.agree.session.defaults;

import cn.agree.mapper.UserMapper;
import cn.agree.session.SqlSession;

public class DefaultSqlSession implements SqlSession {

    @Override
    public UserMapper getMapper(Class<UserMapper> userMapperClass) {
        return null;
    }

    @Override
    public void close() {

    }
}
