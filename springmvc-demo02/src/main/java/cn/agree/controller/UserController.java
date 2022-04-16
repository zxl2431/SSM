package cn.agree.controller;

import cn.agree.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/add/adduser")
    public String addUser() {
        return "add_user";
    }

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


    /*
    * 基于servletAPI的实现请求转发
    *
    * */
    @RequestMapping(value = "/servlet/forward")
    public void servletForward(HttpServletRequest request, HttpServletResponse response, Model model) throws ServletException, IOException {
        // 将数据放入Model中
        model.addAttribute("msg", "你长的好美");
        // 存入Request作用域中
        request.setAttribute("username", "小红");
        // 转发
        request.getRequestDispatcher("/WEB-INF/pages/add_user.jsp").forward(request, response);
    }

    /*
    *  基于servletAPI实现重定向
    *
    * */
    @RequestMapping(value = "/servlet/redirect")
    public void servletRedirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // 将一个数据存入到Model中
        response.sendRedirect("http://www.baidu.com");
    }

    /*
    *  返回modelandview
    *  逻辑视图名和数据模型放到一起存储
    *
    * */
    @RequestMapping(value = "/model/view")
    public ModelAndView list() {
        ModelAndView modelAndView = new ModelAndView();
        // 逻辑数据
        modelAndView.addObject("name", "小花");

        User user = new User();
        user.setUsername("张三");
        user.setBirthday(new Date());

        User user1 = new User();
        user1.setUsername("李四");
        user1.setBirthday(new Date());

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user);

        // 将一个集合对象放到ModelAndView中
        modelAndView.addObject("users", users);

        // 封装逻辑视图名
        modelAndView.setViewName("list_user");

        return modelAndView;

    }

    /*
    *  基于SpringMVC实现重定向
    *
    * */
    @RequestMapping(value = "/mvc/redirect")
    public String mvcRedirect(Model model) {
        // 讲一个数据存放到model中
        model.addAttribute("username", "太极张三丰");
        return "redirect:http://www.baidu.com";
    }

    /*
    *  基于SpringMVC实现的请求转发
    *
    * */
    @RequestMapping(value = "/mvc/forward")
    public String mvcForward(Model model) {
        //将数据存入Model中
        model.addAttribute("msg","你长得好美！");

        //存入Request作用域
        // request.setAttribute("username","小红");

        // 并不能使用视图解析器, 路径需要写全
        return "forward:/WEB-INF/pages/add_user.jsp";

    }

    /*
    *  @RequestBody: 前台如果传的数据是非JSON
    *               处理 username=小红&userbirthday=
    *               使用前提:POST
    *
    * */
    @RequestMapping(value = "/request/body/str")
    public String requestBodyString(@RequestBody String body){
        System.out.println(body);
        return "add_user";
    }

    /***
     * @RequestBody:前台如果传的数据为JSON
     *              处理：后台直接用对应的JavaBean接收
     *              使用前提：提交方式为POST
     * @return
     */
    @RequestMapping(value = "/request/body/json")
    public String requestBodyJSON(@RequestBody User user){
        System.out.println(user);
        return "add_user";
    }


    /*
    *  @ResponseBody: 只需要在方法上加该注解,则会响应JSON格式数据
    *               如果是一个JavaBean,则响应JSON格式
    *               如果是基本数据类型或者String,则直接响应文本
    *
    * */
    @ResponseBody
    @RequestMapping(value = "/response/body/json")
    public User jsonResponse() {
        //User对象创建
        User user = new User();
        user.setUsername("毛毛虫");
        user.setMoney(199);
        user.setBirthday(new Date());
        user.setPassword("123");

        return user;
    }

    @RequestMapping(value = "/hello")
    public String userHello() {
        System.out.println("userHello执行成功");
        return "success";
    }

}
