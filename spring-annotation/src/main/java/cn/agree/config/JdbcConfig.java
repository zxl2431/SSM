package cn.agree.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {

    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /*
    * 创建一个数据源,并存入spring容器中
    *
    *
    * */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            /* 这是写死的模式 并不推荐 */
            // ds.setUser("root");
            // ds.setPassword("root");
            // ds.setDriverClass("com.mysql.jdbc.Driver");
            // ds.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/db1");

            /*使用配置文件的方式*/
            ds.setUser(username);
            ds.setPassword(password);
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);

            return ds;
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    *  创建一个QueryRunner, 存入spring容器中
    *
    * */
    @Bean(name = "runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource) {
        return new QueryRunner(dataSource);
    }

}
