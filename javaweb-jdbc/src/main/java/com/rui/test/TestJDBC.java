package com.rui.test;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //配置信息
        String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8";
        String username = "root";
        String password = "Cc105481";

        //加载驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //连接数据库，代表数据库
        Connection connection = DriverManager.getConnection(url, username, password);
        //编写SQL
        String sql = "insert into users(id, name, password, email, birthday) VALUES (?,?,?,?,?);";
        //预编译
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,4);
        preparedStatement.setString(2,"JAVA");
        preparedStatement.setString(3,"123456");
        preparedStatement.setString(4,"123123123@qq.com");
        preparedStatement.setDate(5, new Date(new java.util.Date().getTime()));

        //执行Sql
        int i = preparedStatement.executeUpdate();
        if (i>0){
            System.out.println("插入成功，共插入了"+i+"行");
        }
        //关闭连接释放资源
        preparedStatement.close();
        connection.close();
    }
}
