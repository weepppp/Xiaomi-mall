package com.tang.dao.impl;

import com.tang.dao.CategoryDao;
import com.tang.entity.Category;
import com.tang.utils.JDBCutils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 9:35
 * @version V1.0
 * @since
 **/
public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<Category> selectByeachPage(Integer eachPage) throws SQLException {
        String sql = "select * from category limit ?";
        List<Category> list = JDBCutils.qr.query(sql, new BeanListHandler<Category>(Category.class), eachPage);
        return list;
    }
}
