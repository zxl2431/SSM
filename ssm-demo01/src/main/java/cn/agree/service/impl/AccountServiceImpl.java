package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        System.out.println("Service.saveAccount..."+account);


    }

    @Override
    public List<Account> findAll() {
        System.out.println("Service.findAll()...");
        return null;
    }
}
