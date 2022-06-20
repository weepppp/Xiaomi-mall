package com.tang.service;

import com.tang.entity.Product;
import com.tang.utils.PageUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 11:00
 * @version V1.0
 * @since
 **/
public interface ProductService {
    List<Product> selectByState(Integer state) throws SQLException;
    List<Product> selectByName(String name) throws SQLException;
    Product selectById(Integer sid) throws SQLException;
    PageUtils<Product> selectByPage(String name, Integer state, String startTime
            , String endTime, String currentPage, String eachPage);
}
