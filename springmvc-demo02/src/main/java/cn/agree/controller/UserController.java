package cn.agree.controller;

import cn.agree.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/initUpdate")
    public String initUpdate(Model model) {
        System.out.println("------");
        // 模拟从数据库中查询的数据
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setMoney(100d);
        user.setBirthday(new Date());
        model.addAttribute("user", user);
        return "updateUser";

    }

    /*
    *  向用户输出一段话,不跳转到某个jsp
    *
    *  使用ServletAPI
    *   直接将对应的ServletAPI中的对象当中参数传入即可使用
    *
    * */
    @RequestMapping(value = "/add/text")
    public void addUesrWriterText(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("void");

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取一个PrintWriter对象
        PrintWriter writer = response.getWriter();
        writer.write("你说啥就是傻");
        writer.flush();
        writer.close();
        return;
    }




}
