package cn.agree.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = "cn.agree")
@PropertySource("classpath:jdbc.properties")
@EnableTransactionManagement
public class SpringConfiguration {

    @Value("${jdbc.url}")
    private String jdbcurl;
    @Value("${jdbc.driverClass}")
    private String driverClass;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    /*
    *  创建JdbcTemplate
    *
    * */
    @Bean(name = "jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);

        return jdbcTemplate;
    }

    /*
    *  创建事务管理器
    * */
    @Bean(name = "txtManager")
    public DataSourceTransactionManager createTxtManager(DataSource dataSource) {
        // 创建事务管理器对象
        DataSourceTransactionManager txtManager = new DataSourceTransactionManager();
        txtManager.setDataSource(dataSource);

        return txtManager;
    }

    /*
    *  创建数据源
    *
    * */
    @Bean(name = "dataSource")
    public DataSource createDataSource() {
        try {
            ComboPooledDataSource dataSource = new ComboPooledDataSource();
            dataSource.setJdbcUrl(jdbcurl);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            dataSource.setDriverClass(driverClass);

            return dataSource;
        } catch (PropertyVetoException e) {
            throw  new RuntimeException(e);
        }
    }

}
