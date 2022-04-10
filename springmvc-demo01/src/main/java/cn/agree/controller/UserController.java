package cn.agree.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    /*
    *  接收基本类型和String
    *  http://localhost:8081/user/add?id=9&name=赞同科技
    *
    * */
    @RequestMapping(value = "/add")
    public String addUser(int id, String name) {
        System.out.println("id:"+id + ", name"+name);
        return "success";
    }

}
