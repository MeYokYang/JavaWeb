package cn.itcase.dao;

import cn.itcase.domain.User;
import cn.itcase.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;


public class UserDao {

    //declare JDBCTemplate object to share
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * login method
     * @param loginUser only username and password
     * @return include all data of user. If querying failed, return null.
     */
    public User login(User loginUser){
        try {
            String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (Exception e) {
//            e.printStackTrace(); //record log
            return null;
        }
    }
}
