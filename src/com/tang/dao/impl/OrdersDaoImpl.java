package com.tang.dao.impl;

import com.tang.dao.OrdersDao;
import com.tang.entity.Orders;
import com.tang.utils.JDBCutils;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/15 12:18
 * @version V1.0
 * @since
 **/
public class OrdersDaoImpl implements OrdersDao {
    @Override
    public Integer addOrders(Orders orders) throws SQLException {
        String sql = "insert into orders(orders_number,uid,sum_price,state,create_time,count_number)values(?,?,?,?,?,?)";
        Object[] objects = {orders.getOrders_number(),orders.getUid(),orders.getSum_price(),orders.getState(),orders.getCreate_time(),orders.getCount_number()};
        int i = JDBCutils.qr.update(sql, objects);
        return i;
    }

    @Override
    public List<Orders> selectById(Integer uid) throws SQLException {
        String sql = "select * from orders where uid = ?";
        List<Orders> ordersList = JDBCutils.qr.query(sql, new BeanListHandler<Orders>(Orders.class), uid);
        return ordersList;
    }
}
