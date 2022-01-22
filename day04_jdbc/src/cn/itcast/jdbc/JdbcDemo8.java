package cn.itcast.jdbc;

/*
* 定义一个方法，查询account表的数据将其封装为对象，然后装载集合，返回
* */

import cn.itcast.domain.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo8 {

    public static void main(String[] args) {
        List<Account> list = new JdbcDemo8().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    public List<Account> findAll(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Account> list = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///db3", "root", "root");
            String sql = "SELECT * FROM account";
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            Account account = null;
            list = new ArrayList<Account>();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");

                account = new Account();
                account.setId(id);
                account.setName(name);
                account.setBalance(balance);

                list.add(account);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            if(resultSet != null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

}
