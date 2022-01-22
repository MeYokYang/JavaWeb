package cn.itcast.jdbc;

/*
* 定义一个方法，查询account表的数据将其封装为对象，然后装载集合，返回
* */

import cn.itcast.domain.Account;
import cn.itcast.util.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo9 {

    public static void main(String[] args) {
        List<Account> list = new JdbcDemo9().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    public List<Account> findAll(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Account> list = null;

        try {
            connection = JdbcUtils.getConnection();
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

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(resultSet, statement, connection);
        }

        return list;
    }

}
