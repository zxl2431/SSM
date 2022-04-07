import cn.agree.pojo.Account;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo1 {

    private JdbcTemplate jdbcTemplate;

    @Before
    public void init() {
        // 获取Spring容器
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean0.xml");
        // 根据id获取bean对象
        jdbcTemplate = (JdbcTemplate) ac.getBean("jdbcTemplate");
    }

    @Test
    public void insertAccount() {
        jdbcTemplate.execute("insert into account(name, balance) VALUES ('王五', 500)");
    }

    @Test
    public void updateAccount() {
        jdbcTemplate.update("insert into account(name, balance) VALUES (?, ?)", "赵六", 1000);
    }

    @Test
    public void updateAccount1() {
        jdbcTemplate.update("update account set balance = balance-? where id = ?", 100, 1);
    }

    @Test
    public void delete() {
        jdbcTemplate.update("delete from account where id=?", 6);
    }

    @Test
    public void findAll() {
        List<Account> accounts = jdbcTemplate.query("select * from account where balance > ?", new BeanPropertyRowMapper<Account>(Account.class), 10);

        for (Account acc : accounts) {
            System.out.println(acc);
        }
    }

    /*
    *  查询返回 一行一列操作
    *
    * */
    @Test
    public void findRow() {
        Integer total = jdbcTemplate.queryForObject("select count(*) from account", Integer.class);
        System.out.println(total);
    }

}
