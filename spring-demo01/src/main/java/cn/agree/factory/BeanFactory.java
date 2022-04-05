package cn.agree.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeanFactory {
    // 定义Properites对象,用户存放解析信息
    private static Properties props = new Properties();
    private static Map<String, Object> beans = new HashMap<>();

    // 使用静态代码块为props对象赋值
    static {
        try {
            // 读取配置文件
            InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("beans.properties");
            // 加载配置文件字节输入流
            props.load(in);
            // 读取配置文件,获取所有的key
            Enumeration<Object> keys = props.keys();
            // 遍历所有的key
            while (keys.hasMoreElements()) {
                // 获得key
                String key = keys.nextElement().toString();
                // 获取key对应的类全限定名
                String beanPath = (String) props.get(key);
                // 获取字节码对象
                Object value = Class.forName(beanPath).newInstance();
                beans.put(key, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
    *  根据Bean的名称获取对象
    *
    * */
    public static Object getBean(String beanName) {
        return beans.get(beanName);
    }

    /*
    * 获取容器中所有的Beans
    * */
    public static void printBean() {
        for (String key : beans.keySet()) {
            System.out.println("key:"+key+"---"+beans.get(key));
        }
    }

}
