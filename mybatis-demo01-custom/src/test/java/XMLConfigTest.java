import cn.agree.session.util.XMLConfigBuilder;
import org.junit.Test;

import java.io.InputStream;

public class XMLConfigTest {

    @Test
    public void parseXML() {
        InputStream is = XMLConfigTest.class.getClassLoader().getResourceAsStream("SqlMapConfig.xml");
        XMLConfigBuilder.loadConfiguration(is);
        XMLConfigBuilder.loadMapper("cn/agree/mapper/UserMapper.xml");
    }
}
