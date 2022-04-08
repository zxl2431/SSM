package cn.agree.session.util;

import cn.agree.io.Resources;
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
            System.out.println("configuration对象获取的连接池:"+cfg.getConnection());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    *  解析UserMapper.xml文件
    *  提取SQL语句和返回JavaBean全限定名
    *
    * */
    public static void loadMapper(String path) {
        try {
            InputStream is = Resources.getResourceAsStream(path);

            // 创建SAXReader对象,加载文件字节输入流
            SAXReader reader = new SAXReader();
            Document document = reader.read(is);

            //获取根节点
            Element rootElement = document.getRootElement();

            //获取命名空间的值
            String namespace = rootElement.attributeValue("namespace");

            //获取所有的select节点
            List<Element> selectList = document.selectNodes("//select");

            //循环所有select节点
            for (Element element : selectList) {
                // 获取ID属性值
                String id = element.attributeValue("id");
                // 获取resultType属性值
                String resulteType = element.attributeValue("resultType");
                // 获取SQL
                String sql = element.getText();
                System.out.println("loadMapper解析的结果:"+id+"---"+resulteType+"---"+sql);
            }

        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }

}
