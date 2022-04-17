package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        System.out.println("Service.saveAccount..."+account);
        accountDao.saveAccount(account);


    }

    @Override
    public List<Account> findAll() {
        System.out.println("Service.findAll()...");
        return accountDao.findAll();
    }
}
