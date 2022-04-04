package cn.agree.jdbc;

import java.sql.*;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1 注册驱动
        // 最早的时候使用 new一个数据库驱动
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        // 后来我们使用class.forname字符串的方式 因为Driver里面已经有一个静态代码块去注册了.
        Class.forName("com.mysql.jdbc.Driver");

        // Class<?> driver = Class.forName("driver");

        //2 获取连接
        Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1", "root", "root");
        System.out.println(connection);

        //3 获取操作数据库的预处理对象
        PreparedStatement pstm = connection.prepareStatement("select * from account");
        //4 执行SQL
        ResultSet resultSet = pstm.executeQuery();
        //5 遍历结果
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }
        //6 关闭资源
        resultSet.close();
        pstm.close();
        connection.close();



    }
}
