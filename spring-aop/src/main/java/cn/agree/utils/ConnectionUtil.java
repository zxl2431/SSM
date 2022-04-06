package cn.agree.utils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


/*
*  一个管理连接工具类, 用于实现连接connection和线程thread的绑定
*
* */
public class ConnectionUtil {

    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /*
    *  获取当前线程上绑定的连接
    *
    * */
    public Connection getThreadConnection() {
        try {
            // 1.先看看线程上是否绑定
            Connection conn = tl.get();
            if (conn == null) {
                //2.从数据源中获取一个连接
                conn = dataSource.getConnection();
                //3.和线程局部变量绑定
                tl.set(conn);
            }
            // 4.返回线程上的连接
            return tl.get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    *  把连接和当前线程解绑
    *
    * */
    public void remove() {
        tl.remove();
    }




}
