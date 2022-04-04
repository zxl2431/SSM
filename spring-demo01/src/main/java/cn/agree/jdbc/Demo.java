package cn.agree.jdbc;

import java.sql.DriverManager;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
        // 注册驱动
        Class.forName("driver");

    }
}
