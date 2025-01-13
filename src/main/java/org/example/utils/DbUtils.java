package org.example.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtils {

    static String url = "jdbc:postgresql://194.163.145.131:5432/postgres";
    static String user = "postgres";
    static String password = "postgres";
    public static Connection getConn() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
