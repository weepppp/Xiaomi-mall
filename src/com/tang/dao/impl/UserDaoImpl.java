package com.tang.dao.impl;

import com.tang.dao.UserDao;
import com.tang.entity.User;
import com.tang.utils.JDBCutils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/13 14:42
 * @version V1.0
 * @since
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public User selectByUsername(String username) throws SQLException {
        String sql = "select * from user where username = ?";
        User user;
        user = JDBCutils.qr.query(sql, new BeanHandler<User>(User.class), username);
        if (user != null) {
            return user;
        }
      return null;
    }

    @Override
    public boolean selectByPhoneNumber(String phonenumber) throws SQLException {
        String sql = "select * from user where phone_number = ?";
        User user;
        user = JDBCutils.qr.query(sql, new BeanHandler<User>(User.class), phonenumber);
        if (user == null) {
            return true;
        }
        return false;
    }

    @Override
    public int addUser(User user) throws SQLException {
        String sql = "insert into user(name,sex,phone_number,area,manager,username,password,photo,create_time)values(?,?,?,?,?,?,?,?,?)";
        Object [] objects = {user.getName(),user.getSex(),user.getPhone_number(),user.getArea(),user.getManager(),
                        user.getUsername(),user.getPassword(),user.getPhoto(),user.getCreate_time()};
        int i = JDBCutils.qr.update(sql, objects);
        return i;
    }

    @Override
    public User selectAdmin(String username, String password, Integer manager) throws SQLException {
        String sql = "select * from user where username = ? and password = ? and manager = ?";
        Object[] objects = {username,password,manager};
        User user = JDBCutils.qr.query(sql, new BeanHandler<User>(User.class), objects);
        return user;
    }






    @Override
    public List<User> selectPage(Integer currentPage, Integer eachPage) throws SQLException {
        String sql = "select * from user limit ?,?";
        Object[] objects = {(currentPage - 1)*eachPage,eachPage};
        List<User> userList = JDBCutils.qr.query(sql, new BeanListHandler<User>(User.class), objects);
        return userList;
    }

    @Override
    public Integer selectCount() throws SQLException {
        String sql = "select count(1) from user";
        Long i = (Long) JDBCutils.qr.query(sql,new ScalarHandler());
        return i == null ? 0:Integer.parseInt(i+"");
    }

    @Override
    public Integer updateManager(Integer id, Integer manager) throws SQLException {
        String sql = "update user set manager = ? where id  = ?";
        Object[] objects = {manager,id};
        int i = JDBCutils.qr.update(sql, objects);
        return i;
    }

    @Override
    public Integer deleteById(Integer id) throws SQLException {
        String sql = "delete from user where id  = ?";
        int i = JDBCutils.qr.update(sql, id);
        return i;
    }

    @Override
    public User selectById(Integer id) throws SQLException {
        String sql = "select * from user where id = ?";
        User user = JDBCutils.qr.query(sql, new BeanHandler<User>(User.class),id);
        return user;
    }
}
