package com.atguigu.api.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PSUserLoginPart {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入账号");
        String account=scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        Class<?> aClass = Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/atguigu", "root", "root");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user where account =? and password =?");
        preparedStatement.setObject(1, account);
        preparedStatement.setObject(2, password);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id1 = resultSet.getInt("id");
            String account1 = resultSet.getString("account");
            String password1 = resultSet.getString("password");
            String nickname1 = resultSet.getString("nickname");
            System.out.println(id1+"--"+account1+"--"+password1+"--"+nickname1);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
