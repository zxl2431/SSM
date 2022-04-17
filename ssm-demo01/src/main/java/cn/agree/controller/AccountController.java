package cn.agree.controller;

import cn.agree.domain.Account;
import cn.agree.service.AccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/account")
public class AccountController {

    private AccountService accountService;

    /*
    *  查询所有
    *
    * */
    @RequestMapping(value = "/findAll")
    public String findAll() {
        return "list";
    }

    /*
    *  保存账户
    *
    * */
    @RequestMapping(value = "/add")
    public String add(Account account) {
        return "redirect:/accoount/findAll";
    }
}
