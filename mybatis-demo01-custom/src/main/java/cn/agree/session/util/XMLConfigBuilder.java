package cn.agree.session.util;

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
    *
    * */
    public static void loadConfiguration(InputStream is) {
        try {
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

                System.out.println(name+"---"+value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
