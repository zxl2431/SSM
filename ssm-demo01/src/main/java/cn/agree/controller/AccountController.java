package cn.agree.controller;

import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    /*
    *  查询所有
    *
    * */
    @RequestMapping(value = "/findAll")
    public String findAll() {
        List<Account> accounts = accountService.findAll();
        return "list";
    }

    /*
    *  保存账户
    *
    * */
    @RequestMapping(value = "/add")
    public String add(Account account) {
        accountService.saveAccount(account);
        return "redirect:/account/findAll";
    }
}
