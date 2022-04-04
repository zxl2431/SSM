import cn.agree.service.AccountService;
import cn.agree.service.impl.AccountServiceImpl;

public class Test01 {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }
}
