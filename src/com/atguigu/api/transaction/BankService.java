package com.atguigu.api.transaction;

import com.atguigu.api.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class BankService {
    public void transfer(String addAccount,String subAccount,int money) throws Exception {
        Connection connection = JdbcUtils.getConnection();
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        String url = "jdbc:mysql://localhost:3306/atguigu";
//        Connection connection = DriverManager.getConnection(url, "root", "root");

        try {
            connection.setAutoCommit(false);
            BankDao bankDao = new BankDao();
            bankDao.add(addAccount,money);
            System.out.println("--------------------------------");
            bankDao.sub(subAccount,money);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw new Exception(e);
        }finally {
            JdbcUtils.close(connection);
        }
    }
    @Test
    public void test() throws Exception {
        transfer("lvdandan","ergouzi",500);
    }
}
