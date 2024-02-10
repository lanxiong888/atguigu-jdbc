package com.atguigu.api.preparedstatement;

import org.junit.Test;

import java.sql.*;

public class PSOtherPart {
    @Test
    public void returnPrimaryKey() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        String sql = "insert into t_user(account,password,nickname) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, "kun");
        preparedStatement.setString(2, "123456");
        preparedStatement.setString(3, "love kun");
        int i = preparedStatement.executeUpdate();
        if (i > 0) {
            System.out.println("插入成功");
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int id = resultSet.getInt(1);
            ;
            System.out.println("id=" + id);
        } else {
            System.out.println("插入失败");
        }
        preparedStatement.close();
        connection.close();
    }

    @Test
    public void insert10000() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        String sql = "insert into t_user(account,password,nickname) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            preparedStatement.setString(1, "kun kun" + i);
            preparedStatement.setString(2, "123456" + i);
            preparedStatement.setString(3, "love kun" + i);
            preparedStatement.executeUpdate();

        }
        long end = System.currentTimeMillis();
        System.out.println("时间" + (end - start));

        preparedStatement.close();
        connection.close();
    }

    @Test

    public void insert10000time() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu?rewriteBatchedStatements=true";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        String sql = "insert into t_user(account,password,nickname) values(?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            preparedStatement.setString(1, "kun kun" + i);
            preparedStatement.setString(2, "123456" + i);
            preparedStatement.setString(3, "love kun" + i);
            preparedStatement.addBatch();

        }
        preparedStatement.executeBatch();
        long end = System.currentTimeMillis();
        System.out.println("时间" + (end - start));

        preparedStatement.close();
        connection.close();
    }


}
