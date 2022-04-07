package cn.agree.service.impl;

import cn.agree.service.AccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存了账户...");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新了账户..."+i);
        int q = 1/0;
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除了账户...");

        return 0;
    }
}
