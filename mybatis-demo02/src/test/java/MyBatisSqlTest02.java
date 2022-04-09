import cn.agree.domain.AccountCustomer;
import cn.agree.mapper.AccountMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MyBatisSqlTest02 {

    private SqlSession sqlSession;
    private AccountMapper accountMapper;

    @Before
    public void init() throws IOException {
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = builder.build(is);
        sqlSession = sqlSessionFactory.openSession();
        accountMapper = sqlSession.getMapper(AccountMapper.class);
    }

    @Test
    public void testfindAccountList() {
        List<AccountCustomer> accountCustomers = accountMapper.findAccountList();
        for (AccountCustomer ac : accountCustomers) {
            System.out.println(ac);
        }
    }
}
