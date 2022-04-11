package cn.agree.domain;

public class Student {
    private String username;

    private String telephone;

    private Integer hight;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getHight() {
        return hight;
    }

    public void setHight(Integer hight) {
        this.hight = hight;
    }

    @Override
    public String toString() {
        return "Student{" +
                "username='" + username + '\'' +
                ", telephone='" + telephone + '\'' +
                ", hight=" + hight +
                '}';
    }
}
