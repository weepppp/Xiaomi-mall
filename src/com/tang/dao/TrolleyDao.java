package com.tang.dao;

import com.tang.entity.Trolley;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 14:57
 * @version V1.0
 * @since
 **/
public interface TrolleyDao {
    Trolley select(Integer uid,Integer pid) throws SQLException;
    Integer addTrolley(Trolley trolley) throws SQLException;
    Integer updateTrolley(Trolley trolley) throws SQLException;
    Integer selectCount(Integer uid) throws SQLException;
    List<Trolley> selectTrolley(Integer uid) throws SQLException;
    Integer deleteById(String tid) throws SQLException;
    Integer updateTrolley(int uid,String orders_number) throws SQLException;
    List<Trolley> selectTrolleyOrders(int uid) throws SQLException;
    List<Trolley> selectTrolleyOrders(String orders_number) throws SQLException;
}
