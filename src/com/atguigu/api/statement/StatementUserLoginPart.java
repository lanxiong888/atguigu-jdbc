package com.atguigu.api.statement;

import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class StatementUserLoginPart {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号");
        String account=scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
//        DriverManager.registerDriver(new Driver());
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Properties properties = new Properties();
        properties.put("user","root");
        properties.put("password","root");
//        Connection connection = DriverManager.getConnection("jdbc:mysql:///atguigu","root","root");
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", properties);
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu?user=root&password=root", properties);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from t_user where account = '" + account + "' and password = '" + password + "'");
        while (resultSet.next()) {
//            int id1 = resultSet.getInt("id");
//            String account1 = resultSet.getString("account");
//            String password1 = resultSet.getString("password");
//            String nickname1 = resultSet.getString("nickname");
//            System.out.println(id1+"--"+account1+"--"+password1+"--"+nickname1);

            int id1 = resultSet.getInt(1);
            String account1 = resultSet.getString(2);
            String password1 = resultSet.getString(3);
            String nickname1 = resultSet.getString(4);
            System.out.println(id1+"--"+account1+"--"+password1+"--"+nickname1);
        }
        resultSet.close();
        statement.close();
        connection.close();


    }
}
