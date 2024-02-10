package com.atguigu.api.transaction;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class BankService {
    public void transfer(String addAccount,String subAccount,int money) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/atguigu";
        Connection connection = DriverManager.getConnection(url, "root", "root");

        try {
            connection.setAutoCommit(false);
            BankDao bankDao = new BankDao();
            bankDao.add(addAccount,money,connection);
            System.out.println("--------------------------------");
            bankDao.sub(subAccount,money,connection);
            connection.commit();
        } catch (Exception e) {
            connection.rollback();
            throw new Exception(e);
        }finally {
            connection.close();
        }
    }
    @Test
    public void test() throws Exception {
        transfer("lvdandan","ergouzi",500);
    }
}
