package cn.agree.session;

/*
*  Configuration对象
*  存储解析数据库连接信息
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
