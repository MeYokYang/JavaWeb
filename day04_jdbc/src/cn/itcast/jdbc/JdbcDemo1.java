package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //3.获取数据库连接对象
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db3", "root", "root");
        //4.定义sql语句
        String sql = "update account set balance = 2000";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();;
        conn.close();

        /*
        * DriverManager:驱动管理对象
        *   1.注册驱动:告诉程序该使用
        *       static void registerDriver(Driver driver):注册与给定的驱动程序 DriverManager
        *       写代码使用:Class.forName("com.mysql.jdbc.Driver");
        *       通过查看源码发现:在com.mysql.jdbc.Driver类中存在静态代码块
        *       java.sql.DriverManager.registerDriver(new Driver());
        *       注意:mysql5之后的驱动jar包可以省略注册驱动的步骤。
        *   2.获取数据库连接:
        *       方法:static Connection getConnection(String url, String user, String passward)
        *       参数:
        *           url:指定连接的路径
        *               语法(mysql):jdbc:mysql://ip地址(域名):端口号/数据库名称
        *               细节:如果连接的时本机mysql服务器，并且mysql服务器默认端口是3306，则url可以简写为：jdbc:mysql:///db3
        *           user:用户名
        *           passward:密码
        * Connection:数据库连接对象
        *   1.功能
        *       1.获取执行sql的对象
        *           Statement createStatement()
        *           PreparedStatement prepareStatement(String sql)
        *       2.管理事务
        *           开启事务:void setAutoCommit(boolean autoCommit) :调用该方法设置参数为false，即开启事务
        *           提交事务:void commit()
        *           回滚事务:void rollback()
        * Statement:执行sql对象
        *   1.执行sql
        *       1.boolean execute(String sql) :可以执行任意的sql，了解
        *       2.int executeUpdate(String sql) :执行DML、DDL语句
        *           返回值:DML:影响的行数，可以通过影响的行数判断DML语句是否执行成功
        *       3.ResultSet executeQuery(String sql) :执行DQL语句
        * ResultSet:结果集对象,封装查询结果
        *   boolean next():游标向下移一行,返回值为是否为最后一行，是返回false
        *   Xxx getXxx(parameter):获取数据
        *       Xxx:表示数据类型
        *       parameter:
        *           int:代表列的编号，从1开始。
        *           String:代表列的名称。
        * PreparedStatement:执行sql对象
        * */
    }

}
