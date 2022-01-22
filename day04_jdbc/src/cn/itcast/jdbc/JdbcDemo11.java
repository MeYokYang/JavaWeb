package cn.itcast.jdbc;

import cn.itcast.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDemo11 {

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement1 = null;
        PreparedStatement preparedStatement2 = null;
        try {
            connection = JdbcUtils.getConnection();
            connection.setAutoCommit(false);
            String sql1 = "UPDATE account SET balance = balance - ? WHERE id = ?";
            String sql2 = "UPDATE account SET balance = balance + ? WHERE id = ?";
            preparedStatement1 = connection.prepareStatement(sql1);
            preparedStatement2 = connection.prepareStatement(sql2);
            preparedStatement1.setInt(1, 500);
            preparedStatement1.setDouble(2,1);
            preparedStatement2.setInt(1, 500);
            preparedStatement2.setDouble(2,2);

            preparedStatement1.executeUpdate();
            preparedStatement2.executeUpdate();

            connection.commit();
        } catch (Exception e) {
            try {
                if(connection != null){
                    connection.rollback();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JdbcUtils.close(preparedStatement1, connection);
            JdbcUtils.close(preparedStatement2, null);
        }
    }

}
