package cn.agree.service.impl;

import cn.agree.dao.AccountDao;
import cn.agree.pojo.Account;
import cn.agree.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public Account findAccountById(Integer id) {
        return accountDao.findAccountById(id);
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void transfer(String sourceName, String targeName, double money) {
        // 1.根据名称查询两个账户
        Account source = accountDao.findAccountByName(sourceName);
        Account target = accountDao.findAccountByName(targeName);
        System.out.println("转出账户:"+source);
        System.out.println("转入账户:"+target);
        // 2.修改两个账户的金额
        source.setBalance(source.getBalance() - money);
        target.setBalance(target.getBalance() + money);
        // 3.更新两个账户
        accountDao.updateAccount(source);
        // 出现以外
        int q = 1/0;
        accountDao.updateAccount(target);
    }
}
