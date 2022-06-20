package com.tang.service;

import com.tang.entity.Orders;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/15 12:22
 * @version V1.0
 * @since
 **/
public interface OrdersService {
    Integer addOrders(Orders orders) throws SQLException;
    List<Orders> selectById(Integer uid) throws SQLException;
}
