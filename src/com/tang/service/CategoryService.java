package com.tang.service;

import com.tang.entity.Category;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 9:38
 * @version V1.0
 * @since
 **/
public interface CategoryService {
    List<Category> selectByeachPage(Integer eachPage) throws SQLException;
}
