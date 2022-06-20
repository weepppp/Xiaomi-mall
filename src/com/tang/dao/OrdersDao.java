package com.tang.dao;

import com.tang.entity.Orders;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/15 12:18
 * @version V1.0
 * @since
 **/
public interface OrdersDao {
    Integer addOrders(Orders orders) throws SQLException;
    List<Orders> selectById(Integer uid) throws SQLException;
}
