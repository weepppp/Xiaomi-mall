package com.tang.test;

import com.tang.entity.Category;
import com.tang.service.impl.CategoryServiceImpl;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 10:19
 * @version V1.0
 * @since
 **/
public class Test {
    public static void main(String[] args) throws SQLException {
        CategoryServiceImpl categoryService = new CategoryServiceImpl();
        List<Category> categories = categoryService.selectByeachPage(3);
        System.out.println(categories);
    }
}
