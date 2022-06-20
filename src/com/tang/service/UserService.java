package com.tang.service;

import com.tang.entity.User;
import com.tang.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * @author weepppp 2022/6/13 9:38
 * @version V1.0
 * @since
 **/
public interface UserService {
    User selectByUsername(String username,String password) throws SQLException;
    boolean selectByUsername(String username) throws SQLException;
    boolean selectByPhoneNumber(String phonenumber) throws SQLException;
    int addUser(User user) throws SQLException;
    User selectAdmin(String username,String password,Integer manager) throws SQLException;
    PageUtils<User> selectAdmin(String currentPage,String eachPage) throws SQLException;
    Integer updateManager(Integer id,Integer manager) throws SQLException;
    Boolean deleteById(String id, HttpServletRequest request) throws SQLException;
}
