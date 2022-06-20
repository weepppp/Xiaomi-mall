package com.tang.dao;

import com.tang.entity.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 9:34
 * @version V1.0
 * @since
 **/
public interface CategoryDao {
    List<Category> selectByeachPage(Integer eachPage) throws SQLException;
}
