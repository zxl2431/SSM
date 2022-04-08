package cn.agree.session;


import cn.agree.session.defaults.DefaultSqlSessionFactory;

import java.io.InputStream;

public class SqlSessionFactoryBuilder {

    /*
    *  构建者模式
    *   返回一个工厂
    *
    *   构建一个SqlSessionFactory对象
    *
    * */
    public SqlSessionFactory build(InputStream is) {
        // 创建一个SqlSessionFactory实例
        DefaultSqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory();
        // 给sqlSessionFactory的is属性赋值
        sqlSessionFactory.setIs(is);

        return sqlSessionFactory;
    }

}
