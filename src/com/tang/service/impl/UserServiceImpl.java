package com.tang.service.impl;

import com.tang.dao.UserDao;
import com.tang.dao.impl.UserDaoImpl;
import com.tang.entity.User;
import com.tang.service.UserService;
import com.tang.utils.PageUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/13 14:44
 * @version V1.0
 * @since
 **/
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();

    @Override
    public User selectByUsername(String username, String password) throws SQLException {
        User user = userDao.selectByUsername(username);
        if (user != null) {
            if (user.getPassword() != null) {
                if (password.equals(user.getPassword())) {
                    return user;
                }

            }

        }
        return null;
    }

    @Override
    public boolean selectByUsername(String username) throws SQLException {
        User user = userDao.selectByUsername(username);
        if (user == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean selectByPhoneNumber(String phonenumber) throws SQLException {
        boolean b = userDao.selectByPhoneNumber(phonenumber);
        if (b == true) {
            return true;
        }
        return false;
    }

    @Override
    public int addUser(User user) throws SQLException {
        int i = userDao.addUser(user);
        return i;
    }

    @Override
    public User selectAdmin(String username, String password, Integer manager) throws SQLException {
        return userDao.selectAdmin(username, password, manager);
    }

    @Override
    public PageUtils<User> selectAdmin(String currentPage, String eachPage) throws SQLException {
        Integer currentPage1 = null;
        Integer eachPage1 = null;
        if (currentPage == null || "".equals(currentPage)) {
            currentPage1 = 1;
        } else {
            currentPage1 = Integer.parseInt(currentPage);
        }
        if (eachPage == null || "".equals(eachPage)) {
            eachPage1 = 2;
        } else {
            eachPage1 = Integer.parseInt(eachPage);
        }
        Integer totalPageSum = userDao.selectCount();
        Integer totalPageSize = totalPageSum % 2 == 0 ? totalPageSum / eachPage1 : totalPageSum / eachPage1 + 1;
        List<User> userList = userDao.selectPage(currentPage1, eachPage1);
        PageUtils<User> pageUtils = new PageUtils<>();
        pageUtils.setUlist(userList);
        pageUtils.setEachPage(eachPage1);
        pageUtils.setCurrentPage(currentPage1);
        pageUtils.setTotalPageSize(totalPageSize);
        pageUtils.setTotalPageSum(totalPageSum);
        return pageUtils;
    }

    @Override
    public Integer updateManager(Integer id, Integer manager) throws SQLException {
        return userDao.updateManager(id, manager);
    }

    @Override
    public Boolean deleteById(String id, HttpServletRequest request) throws SQLException {
        String realPath = request.getServletContext().getRealPath("/WEB-INF/upload/");
        String[] s = id.split(",");
        if (s != null && s.length > 0) {
            for (String s1 : s) {
                if (s1 != null && s1.length() > 0) {
                    User user = userDao.selectById(Integer.parseInt(s1));
                    String photo = user.getPhoto();
                    File file = new File(realPath, photo);
                    if (!file.exists()) {
                        throw new RuntimeException("图片不存在");
                    }else {
                        boolean flag = file.delete();
                        if (flag) {
                            userDao.deleteById(Integer.parseInt(s1));
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }
}