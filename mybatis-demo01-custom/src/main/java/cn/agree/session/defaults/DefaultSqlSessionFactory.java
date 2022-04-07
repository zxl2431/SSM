package cn.agree.session.defaults;

import cn.agree.session.SqlSession;
import cn.agree.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    @Override
    public SqlSession openSession() {
        return null;
    }
}
