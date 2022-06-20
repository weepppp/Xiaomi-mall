package com.tang.dao;

import com.tang.entity.Category;
import com.tang.entity.Product;
import com.tang.entity.Trolley;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 10:57
 * @version V1.0
 * @since
 **/
public interface ProductDao {
    List<Product> selectByState(Integer state) throws SQLException;
    List<Product> selectByName(String name) throws SQLException;
    Product selectById(Integer sid) throws SQLException;

    // 双表模糊加分页
    List<Product> selectByPage(String name, Integer state, String startTime, String endTime
            , Integer currentPage, Integer eachPage);

    Integer selectCount(String name,Integer state,String startTime,String endTime);
}
