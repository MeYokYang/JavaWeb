package cn.itcase.test;

import cn.itcase.dao.UserDao;
import cn.itcase.domain.User;
import org.junit.Before;
import org.junit.Test;

public class UserDaoTest {

    User loginUser;

    @Before
    public void init(){
        loginUser = new User();
        loginUser.setUsername("superBaby");
        loginUser.setPassword("123");
    }


    @Test
    public void testLogin(){
        UserDao dao = new UserDao();
        User user = dao.login(loginUser);
        System.out.println(user);
    }
}
