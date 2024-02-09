package com.atguigu.api.statement;

import com.mysql.cj.jdbc.Driver;
import com.sun.xml.internal.bind.v2.TODO;

import java.sql.*;

/*
todo：
    DriverManager
    Connection
    Statement
    ResultSet
 */
public class StatementQueryPart {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        DriverManager.registerDriver(new Driver());
        //2.注册连接
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "root");
        //3.创建发送sql语句对象
        Statement statement = connection.createStatement();
        //4.发送sql语句，并返回结果集
        String sql = "select * from t_user";
        ResultSet result = statement.executeQuery(sql);
        //5.结果集解析
        while (result.next()){
            int id = result.getInt("id");
            String account = result.getString("account");
            String password = result.getString("password");
            String nickname = result.getString("nickname");
            System.out.println(id+"--"+account+"--"+password+"--"+nickname);

        }

        //6.资源关闭
        result.close();
        statement.close();
        connection.close();
    }
}
