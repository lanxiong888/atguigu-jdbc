package com.atguigu.api.transaction;

import com.atguigu.api.druid.JDBCTools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class BankDao {

    public void add(String account,int money)throws Exception{
        Connection connection = JDBCTools.getConnection();
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu";
//        Connection connection = DriverManager.getConnection(url, "root", "root");
//        connection.setAutoCommit(false);
        String sql = "update t_bank set money = money +? where account =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,money);
        preparedStatement.setObject(2,account);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("加钱成功");
        }
//        connection.commit();
        preparedStatement.close();
//        connection.close();


    }

    public void sub(String account,int money)throws Exception{
        Connection connection = JDBCTools.getConnection();

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu";
//        Connection connection = DriverManager.getConnection(url, "root", "root");
//        connection.setAutoCommit(false);
        String sql = "update t_bank set money = money -? where account =?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,money);
        preparedStatement.setObject(2,account);
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("减钱成功");
        }
//        connection.commit();
        preparedStatement.close();
//        connection.close();


    }

}

