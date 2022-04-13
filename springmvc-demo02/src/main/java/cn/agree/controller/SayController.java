package cn.agree.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping(value = "/say")
public class SayController {

    /*
    * Controller方法返回字段可以指定逻辑视图的名称
    * 根据视图解析器为物理视图的地址
    *
    * */
    @RequestMapping(value = "/hello")
    public String sayHello() {
        System.out.println("Hello SpringMVC!");
        return "success";
    }

}
