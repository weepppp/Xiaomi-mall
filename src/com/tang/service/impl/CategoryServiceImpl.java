package com.tang.service.impl;

import com.tang.dao.CategoryDao;
import com.tang.dao.impl.CategoryDaoImpl;
import com.tang.entity.Category;
import com.tang.service.CategoryService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 9:38
 * @version V1.0
 * @since
 **/
public class CategoryServiceImpl implements CategoryService {
    private CategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public List<Category> selectByeachPage(Integer eachPage) throws SQLException {
        return categoryDao.selectByeachPage(eachPage);
    }
}
