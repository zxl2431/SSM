package cn.agree.session.util;

import cn.agree.session.Configuration;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/*
*  解析SqlMapConfig.xml文件
*
* */
public class XMLConfigBuilder {
    /*
    *  传入SqlMapConfig.xml的字节流
    *  得到property的name和value
    *  把这些值存放到Configuration对象中
    * */
    public static void loadConfiguration(InputStream is) {
        try {
            // 数据库配置信息存储
            Configuration cfg = new Configuration();

            // 创建SAXReader对象读取XML文件字节输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(is);

            // 解析配置文件,获取根节点信息 //property表示获取跟节点下所有property节点对象
            List<Element> rootList = document.selectNodes("//property");

            // 循环迭代所有节点对象
            for (Element element : rootList) {
                // name属性值
                String name = element.attributeValue("name");
                // value值
                String value = element.attributeValue("value");
                // System.out.println(name+"---"+value);

                // 将解析的数据库连接信息存储到Configuration中
                if (name.equals("driver")) {
                    cfg.setDriver(value);
                }else if (name.equals("url")) {
                    cfg.setUrl(value);
                }else if (name.equals("username")) {
                    cfg.setUsername(value);
                }else if (name.equals("password")) {
                    cfg.setPassword(value);
                }


            }

            System.out.println("组装的configuration对象:"+ cfg);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
