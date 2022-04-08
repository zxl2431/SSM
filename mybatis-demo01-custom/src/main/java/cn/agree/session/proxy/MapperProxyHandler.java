package cn.agree.session.proxy;

import cn.agree.session.Configuration;
import cn.agree.session.mapper.Mapper;
import cn.agree.session.util.Converter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MapperProxyHandler implements InvocationHandler {
    // Configuration对象, 用于实现数据库增删改查
    private Configuration cfg;

    public MapperProxyHandler(Configuration cfg) {
        this.cfg = cfg;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // 获取方法method定义的类
        Class<?> declaringClass = method.getDeclaringClass();
        // 类的全限定名
        String className = declaringClass.getName();
        // 方法名
        String methodName = method.getName();

        // 拼接key
        String key = className+"."+methodName;

        System.out.println("-----MapperProxyHandler组装的key:"+key);

        // 实现查询
        return list(key);
    }

    /*
    *
    * Mapper
    *
    * */
    public <E> List<E> list(String key) {
        try {
            // 从Configuarion中获取Mapper
            Mapper mapper = cfg.getMappers().get(key);
            // 获取Connection对象
            Connection connection = cfg.getConnection();
            System.out.println("代理对象中获取的连接:"+connection);
            // 获取sql语句
            String sql = mapper.getSql();

            // 获取PrepareStatement
            PreparedStatement stm = connection.prepareStatement(sql);
            // z执行查询
            ResultSet resultSet = stm.executeQuery();

            System.out.println("SQL执行的结果:"+ resultSet);

            // 将结果转换成对应的JavaBean
            return Converter.list(resultSet, Class.forName(mapper.getResultType()));


        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
