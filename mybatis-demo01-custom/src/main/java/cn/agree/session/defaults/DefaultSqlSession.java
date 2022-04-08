package cn.agree.session.defaults;

import cn.agree.mapper.UserMapper;
import cn.agree.session.Configuration;
import cn.agree.session.SqlSession;
import cn.agree.session.proxy.MapperProxyHandler;

import java.lang.reflect.Proxy;
import java.util.List;

public class DefaultSqlSession implements SqlSession {

    // 把Configuration对象给DefaultSqlSession
    private Configuration cfg;

    public void setCfg(Configuration cfg) {
        this.cfg = cfg;
    }

    public Configuration getCfg() {
        return cfg;
    }


    @Override
    public <T> T getMapper(Class<T> clazz) {
        /*
        *  参数:
        *   1) 被代理对象的类加载器
        *   2) 字节数组,让代理对象和被代理对象有相同的行为[即相同的方法]
        *   3) InvocationHandler: 增强代码
        *
        * */
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz},
                new MapperProxyHandler(cfg));
    }


    @Override
    public void close() {

    }

    @Override
    public String toString() {
        return "DefaultSqlSession{" +
                "cfg=" + cfg +
                '}';
    }
}
