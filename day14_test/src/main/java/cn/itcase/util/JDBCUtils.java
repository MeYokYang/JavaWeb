package cn.itcase.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * JDBC utilClass, use Druid connection pool
 */
public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            Properties properties = new Properties();
            InputStream resourceAsStream = JDBCUtils.class.getClassLoader().
                    getResourceAsStream("druid.properties");
            properties.load(resourceAsStream);

            ds = DruidDataSourceFactory.createDataSource(properties);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * get DataSource object
     * @return
     */
    public static DataSource getDataSource(){
        return ds;
    }
    /**
     * get Connection object
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
