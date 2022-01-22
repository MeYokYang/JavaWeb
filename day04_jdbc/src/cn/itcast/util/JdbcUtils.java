package cn.itcast.util;

/*
* JDBC工具类
* */

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static{
        try {

            Properties pro = new Properties();
            ClassLoader classLoader = JdbcUtils.class.getClassLoader();

//            URL resource = classLoader.getResource("jdbc.properties");
//            String path = resource.getPath();
//            pro.load(new FileReader(path));

            InputStream resourceAsStream = classLoader.getResourceAsStream("jdbc.properties");
            pro.load(resourceAsStream);

            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");

            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /*
    * 获取对象
    * */
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }

    public static void close(Statement stmt, Connection conn){
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(ResultSet rs, Statement stmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
