package cn.itcast.jdbc;

/*
 * account表 查询记录
 * */

import java.sql.*;

public class JdbcDemo6 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            String sql = "SELECT * FROM account";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);

            rs.next();
            int anInt = rs.getInt(1);
            String name = rs.getString("name");
            double balance = rs.getDouble("balance");
            System.out.println(anInt+"---"+name+"---"+balance);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
