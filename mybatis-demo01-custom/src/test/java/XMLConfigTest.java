import cn.agree.session.mapper.Mapper;
import cn.agree.session.util.XMLConfigBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Map;

public class XMLConfigTest {

    @Test
    public void parseXML() {
        InputStream is = XMLConfigTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        XMLConfigBuilder.loadConfiguration(is);
        // Map<String, Mapper> mappers = XMLConfigBuilder.loadMapper("cn/agree/mapper/UserMapper.xml");
        // System.out.println(mappers);
    }
}
