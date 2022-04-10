package cn.agree.domain;

import java.util.List;

/*
*  一个角色可以分配给多个人
*
* */
public class Role {
    private Integer id;
    private String role_name;
    private String role_desc;

    // 一个角色多个人
    private List<User> userList;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role_name='" + role_name + '\'' +
                ", role_desc='" + role_desc + '\'' +
                ", userList=" + userList +
                '}';
    }

}
