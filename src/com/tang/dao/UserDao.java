package com.tang.dao;

import com.tang.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/13 9:38
 * @version V1.0
 * @since
 **/
public interface UserDao {
    User selectByUsername(String username) throws SQLException;
    boolean selectByPhoneNumber(String phonenumber) throws SQLException;
    int addUser(User user) throws SQLException;
    User selectAdmin(String username,String password,Integer manager) throws SQLException;
    List<User> selectPage(Integer currentPage,Integer eachPage) throws SQLException;
    Integer selectCount() throws SQLException;
    Integer updateManager(Integer id,Integer manager) throws SQLException;
    Integer deleteById(Integer id) throws SQLException;
    User selectById(Integer id) throws SQLException;
}
