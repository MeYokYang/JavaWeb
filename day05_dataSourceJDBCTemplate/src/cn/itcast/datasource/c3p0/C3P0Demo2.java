package cn.itcast.datasource.c3p0;

/*
* c3p0的演示
* */

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3P0Demo2 {
    public static void main(String[] args) throws SQLException {
        //使用默认配置
        //DataSource ds = new ComboPooledDataSource();
        //使用指定名称配置
        DataSource ds = new ComboPooledDataSource("otherc3p0");
        for (int i = 0; i < 9; i++) {
            Connection connection = ds.getConnection();
            System.out.println(connection);
            if(i == 1){
                connection.close();
            }
        }

    }
}
