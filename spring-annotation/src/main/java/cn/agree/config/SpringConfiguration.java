package cn.agree.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/*
*  @Configuration 相当于bean.xml文件
*  @ComponentScan 配置包扫描
* */
@Configuration
@ComponentScan("cn.agree")
@Import({JdbcConfig.class})
public class SpringConfiguration {

}
