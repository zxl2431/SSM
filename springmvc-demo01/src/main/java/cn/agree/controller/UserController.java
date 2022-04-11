package cn.agree.controller;

import cn.agree.domain.Mobile;
import cn.agree.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        System.out.println("AGE:"+user.getAge() + ", Name:"+user.getName());
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



}
