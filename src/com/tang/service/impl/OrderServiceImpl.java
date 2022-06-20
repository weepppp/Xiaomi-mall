package com.tang.service.impl;

import com.tang.dao.OrdersDao;
import com.tang.dao.ProductDao;
import com.tang.dao.TrolleyDao;
import com.tang.dao.impl.OrdersDaoImpl;
import com.tang.dao.impl.ProductDaoImpl;
import com.tang.dao.impl.TrolleyDaoImpl;
import com.tang.entity.Orders;
import com.tang.entity.Product;
import com.tang.entity.Trolley;
import com.tang.service.OrdersService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/15 12:22
 * @version V1.0
 * @since
 **/
public class OrderServiceImpl implements OrdersService {
    private OrdersDao ordersDao = new OrdersDaoImpl();
    private TrolleyDao trolleyDao = new TrolleyDaoImpl();
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public Integer addOrders(Orders orders) throws SQLException {
        try {
            ordersDao.addOrders(orders);
            trolleyDao.updateTrolley(orders.getUid(),orders.getOrders_number());
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Orders> selectById(Integer uid) throws SQLException {
        List<Orders> ordersList = ordersDao.selectById(uid);
        if (ordersList != null && ordersList.size() != 0) {
            for (Orders orders : ordersList) {
                String orders_number = orders.getOrders_number();
                List<Trolley> trolleyList = trolleyDao.selectTrolleyOrders(orders_number);
                orders.setTrolleyList(trolleyList);
                if (trolleyList != null && trolleyList.size() != 0) {
                    for (Trolley t : trolleyList) {
                        int pid = t.getPid();
                        Product product = productDao.selectById(pid);
                        t.setProduct(product);
                    }
                }
            }
        }
        return ordersList;
    }
}
