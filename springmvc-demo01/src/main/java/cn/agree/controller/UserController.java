package cn.agree.controller;

import cn.agree.domain.Mobile;
import cn.agree.domain.Student;
import cn.agree.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    /*
    *  接收基本类型和String
    *  http://localhost:8081/user/add?id=9&name=赞同科技
    *
    * */
    @RequestMapping(value = "/add")
    public String addUser(User user) {
        System.out.println("AGE:"+user.getAge() + ", Name:"+user.getName()+",birthday:"+user.getBirthday());
        return "success";
    }

    /*
    *  接收Map
    *
    * */
    @RequestMapping(value = "/add1")
    public String addUser(@RequestParam Map userMap) {
        System.out.println(userMap);
        return "success";
    }

    /*
    *  接收List类型的数据
    *
    * */
    @RequestMapping(value = "/add2")
    public String addUser(@RequestParam List<Integer> id) {
        System.out.println(id);
        return "success";
    }

    /*
    *  接收user对象有个属性是IdCard
    *
    *
    * */
    @RequestMapping(value = "/add3")
    public String addUser1(User user) {
        System.out.println("用户:" + user.getName() + "今年:" + user.getAge() + "岁，住在:" + user.getIdCard().getAddress() + ",身份证号是:" + user.getIdCard().getNumber());
        for (Mobile mobile : user.getMobiles()) {
            System.out.println(mobile.getMobileName()+"花了"+mobile.getPrice());
        }
        return "success";
    }

    /*
    *
    *
    * */
    @RequestMapping(value = "/add4")
    public String addUser2(@RequestParam User user) {
        System.out.println(user.toString());
        return "success";
    }

    /*
    *  解析JSON格式提交过来的数据
    *  前台JSON
    *  后台JavaBean
    *
    * */
    /***
     * @RequestBody:前台如果传的数据为JSON
     *              处理：后台直接用对应的JavaBean接收
     *              使用前提：提交方式为POST
     * @return
     */
    @RequestMapping(value = "/request/body/json")
    public String requestBodyJSON(@RequestBody Student student){
        System.out.println(student);
        return "success";
    }

    /*
    * 前台是非JSON的数据
    * */
    @RequestMapping(value = "/request/body/str")
    public String requestBodyString(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    /*
    * @PathVariable注解
    * 拥有绑定url中的占位符
    *
    * */
    @RequestMapping(path = "/request/var/{id}")
    public String requestid(@PathVariable(value = "id") String id) {
        System.out.println(id);
        return "success";
    }



}
