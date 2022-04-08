import cn.agree.session.SqlSession;
import cn.agree.session.defaults.DefaultSqlSession;
import cn.agree.session.mapper.Mapper;
import cn.agree.session.util.XMLConfigBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

public class XMLConfigTest {

    @Test
    public void parseXML() {
        SqlSession sqlSession = new DefaultSqlSession();
        InputStream is = XMLConfigTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        XMLConfigBuilder.loadConfiguration((DefaultSqlSession) sqlSession, is);

        System.out.println(sqlSession);
        // Map<String, Mapper> mappers = XMLConfigBuilder.loadMapper("cn/agree/mapper/UserMapper.xml");
        // System.out.println(mappers);
    }
}
