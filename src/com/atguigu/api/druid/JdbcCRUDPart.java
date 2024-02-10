package com.atguigu.api.druid;

import com.atguigu.api.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class JdbcCRUDPart {
    public static void main(String[] args) throws Exception {
        Connection connection = JdbcUtils.getConnection();
        JdbcUtils.close(connection);
    }
}
