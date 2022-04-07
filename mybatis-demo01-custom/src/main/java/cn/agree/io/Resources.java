package cn.agree.io;

import java.io.InputStream;

/*
*  读取类路径下的文件
*
* */
public class Resources {

    public static InputStream getResourceAsStream(String path) {
        InputStream is = Resources.class.getClassLoader().getResourceAsStream(path);

        return is;
    }

}
