package cn.agree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/parameters")
public class ParametersController {
    /*
    *  Model的使用
    *
    * */
    @RequestMapping(value = "/model")
    public String add(Model model) {
        model.addAttribute("UserInfo","张三");
        return "add_user";
    }



}
