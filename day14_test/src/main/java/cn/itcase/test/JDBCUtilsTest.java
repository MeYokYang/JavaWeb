package cn.itcase.test;

import cn.itcase.util.JDBCUtils;
import org.junit.Test;

public class JDBCUtilsTest {
    @Test
    public void testJDBCUtils(){
        if (JDBCUtils.getDataSource() != null) {
            System.out.println("success");
        }

    }
}
