package com.tang.service;

import com.tang.entity.Trolley;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 15:23
 * @version V1.0
 * @since
 **/
public interface TrolleyService {
    int addTrolley(Trolley trolley) throws SQLException;
    Integer selectCount(Integer uid) throws SQLException;
    List<Trolley> selectTrolley(Integer uid) throws SQLException;
    Integer deleteById(String tid) throws SQLException;
    Integer updateTrolley(int uid,String orders_number) throws SQLException;
    List<Trolley> selectTrolleyOrders(int uid) throws SQLException;
}
