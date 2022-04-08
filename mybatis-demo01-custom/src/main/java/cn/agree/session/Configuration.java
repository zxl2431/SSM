package cn.agree.session;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/*
*  Configuration对象
*  1、存储解析数据库连接信息
*  2、具备获取数据库连接Connection的功能
*
* */
public class Configuration {
    // 数据库用户名
    private String username;
    // 数据用户密码
    private String password;
    // 数据库连接地址
    private String url;
    // 数据库驱动
    private String driver;

    // 创建数据源
    private ComboPooledDataSource dataSource = new ComboPooledDataSource();


    public void setDataSource(ComboPooledDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    /*
     * 创建数据库连接池
     *
     * */
    public ComboPooledDataSource getDataSource() {
        try {
            dataSource.setPassword(this.password);
            dataSource.setUser(this.username);
            dataSource.setJdbcUrl(this.url);
            dataSource.setDriverClass(this.driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    /*
    *  获取数据库连接
    *
    * */
    public Connection getConnection() {
        try {
            return getDataSource().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                ", driver='" + driver + '\'' +
                '}';
    }
}
