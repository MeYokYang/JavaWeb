package cn.itcase.service;

import cn.itcase.domain.PageBean;
import cn.itcase.domain.User;

import java.util.List;
import java.util.Map;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    /**
     * 查询用户所有信息
     * @return
     */
    public List<User> findALl();

    /**
     * 登录方法
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 保存对象
     * @param user
     */
    void add(User user);

    /**
     * 根据id删除user
     * @param id
     */
    void delete(String id);

    /**
     * 根据id查询user
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 根据id更改user
     * @param user
     */
    void update(User user);

    /**
     * 根据id批量删除user
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows, Map<String, String[]> condition);

}
