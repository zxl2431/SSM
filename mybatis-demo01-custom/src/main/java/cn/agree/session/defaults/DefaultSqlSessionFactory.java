package cn.agree.session.defaults;

import cn.agree.session.SqlSession;
import cn.agree.session.SqlSessionFactory;
import cn.agree.session.util.XMLConfigBuilder;

import java.io.InputStream;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    // SqlMapConfig.xml的字节输入流
    private InputStream is;

    public void setIs(InputStream is) {
        this.is = is;
    }

    @Override
    public SqlSession openSession() {
        // 创建一个DefaultSqlSession
        DefaultSqlSession sqlSession = new DefaultSqlSession();

        // 加载解析配置文件
        XMLConfigBuilder.loadConfiguration(sqlSession, is);

        return sqlSession;
    }

}
