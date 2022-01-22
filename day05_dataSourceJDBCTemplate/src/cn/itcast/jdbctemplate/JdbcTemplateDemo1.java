package cn.itcast.jdbctemplate;

import cn.itcast.domain.Account;
import cn.itcast.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo1 {
    /**
     * update:DML
     * queryForMap:列名为key，值为value
     * queryForList:每行为一个map，再将map封装为list
     * query:
     * queryForObject:
     */
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Test
    public void demo1() {
        String sql = "UPDATE account SET balance = 5000 WHERE id = ?";
        int count = template.update(sql, 1);
        System.out.println(count);
    }

    @Test
    public void demo2() {
        String sql = "SELECT * FROM account WHERE id = ? OR id = ?";
        List<Map<String, Object>> maps = template.queryForList(sql, 1, 2);
        for(Map m : maps){
            System.out.println(m);
        }
    }

    @Test
    public void demo3_1() {
        String sql = "SELECT * FROM account";
        List<Account> query = template.query(sql, new RowMapper<Account>() {
            @Override
            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
                Account account = new Account();
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double balance = resultSet.getDouble("balance");
                account.setId(id);
                account.setName(name);
                account.setBalance(balance);
                return account;
            }
        });

        for(Account q : query){
            System.out.println(q);
        }
    }

    @Test
    public void demo3_2() {
        String sql = "SELECT * FROM account";
        List<Account> query = template.query(sql, new BeanPropertyRowMapper<Account>(Account.class));
        for (Account acc : query){
            System.out.println(acc);
        }
    }

    @Test
    public void demo4() {
        String sql = "SELECT COUNT(?) FROM account";
        Long count = template.queryForObject(sql, Long.class, "id");
        System.out.println(count);
    }

}
