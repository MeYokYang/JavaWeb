package cn.itcast.jdbc;

/*
* 定义一个方法，查询account表的数据将其封装为对象，然后装载集合，返回
* */

import cn.itcast.domain.Account;
import cn.itcast.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo10 {

    public static void main(String[] args) {
        List<Account> list = new JdbcDemo10().findAll();
        System.out.println(list);
        System.out.println(list.size());
    }

    public List<Account> findAll(){
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        List<Account> list = null;


        try {
            connection = JdbcUtils.getConnection();
            String sql = "SELECT * FROM account WHERE id = ?";
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, 2);
            resultSet = pstmt.executeQuery();

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
            JdbcUtils.close(resultSet, pstmt, connection);
        }

        return list;
    }

}
