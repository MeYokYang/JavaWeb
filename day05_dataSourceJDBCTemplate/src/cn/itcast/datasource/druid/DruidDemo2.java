package cn.itcast.datasource.druid;

import cn.itcast.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = JDBCUtils.getConnection();
            connection.setAutoCommit(false);
            String sql = "INSERT INTO account VALUES(null,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"yangliu");
            preparedStatement.setDouble(2,3000);
            int i = preparedStatement.executeUpdate();
            System.out.println(i);
            connection.commit();
        } catch (SQLException e) {
            if (connection != null){
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(preparedStatement, connection);
        }


    }
}
