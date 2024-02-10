package com.atguigu.api.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtils {
    public static DataSource database = null;

    static {

        Properties properties = new Properties();
        InputStream ra = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
            properties.load(ra);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        DataSource dataSource = null;
        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    public static Connection getConnection() throws Exception {
        return database.getConnection();
    }

    public static void close(Connection connection) throws Exception {
        connection.close();
    }
}
