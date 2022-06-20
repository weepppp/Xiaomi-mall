package com.tang.dao.impl;

import com.tang.dao.TrolleyDao;
import com.tang.entity.Trolley;
import com.tang.utils.JDBCutils;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 14:59
 * @version V1.0
 * @since
 **/
public class TrolleyDaoImpl implements TrolleyDao {
    @Override
    public Trolley select(Integer uid, Integer pid) throws SQLException {
        String sql = "select * from trolley where uid = ? and pid = ?";
        Object[] objects = {uid,pid};
        Trolley trolley = JDBCutils.qr.query(sql,new BeanHandler<Trolley>(Trolley.class),objects);
        return trolley;
    }

    @Override
    public Integer addTrolley(Trolley trolley) throws SQLException {
        String sql = "insert into trolley(uid,pid,number) values(?,?,?)";
        Object[] objects = {trolley.getUid(),trolley.getPid(),trolley.getNumber()};
        int i = JDBCutils.qr.update(sql, objects);
        return i;
    }

    @Override
    public Integer updateTrolley(Trolley trolley) throws SQLException {
        String sql = "update trolley set number = ? where uid = ? and pid = ?";
        Object[] objects  = {trolley.getNumber(),trolley.getUid(),trolley.getPid()};
        int i = JDBCutils.qr.update(sql, objects);
        return i;
    }

    @Override
    public Integer selectCount(Integer uid) throws SQLException {
        String sql = "select count(1) from trolley where uid = ? and orders_number is null ";
        Long i = (Long) JDBCutils.qr.query(sql, new ScalarHandler(), uid);
        return i == null?0:Integer.parseInt(i+"");
    }

    @Override
    public List<Trolley> selectTrolley(Integer uid) throws SQLException {
        String sql = "select * from trolley where uid = ?";
        List<Trolley> trolleyList = JDBCutils.qr.query(sql, new BeanListHandler<Trolley>(Trolley.class), uid);
        return trolleyList;
    }

    @Override
    public Integer deleteById(String tid) throws SQLException {
        String sql = "delete from trolley where tid in ("+ tid +")";
        int i = JDBCutils.qr.update(sql);
        return i;
    }

    @Override
    public Integer updateTrolley(int uid, String orders_number) throws SQLException {
        String sql="update trolley set orders_number =? where uid =?";
        Object[] objects={orders_number,uid};
        int i = JDBCutils.qr.update(sql, objects);
        return i;
    }

    @Override
    public List<Trolley> selectTrolleyOrders(int uid) throws SQLException {
        String sql = "select * from trolley where uid = ?  and orders_number is null";
        List<Trolley> trolleyList = JDBCutils.qr.query(sql, new BeanListHandler<Trolley>(Trolley.class), uid);
        return trolleyList;
    }

    @Override
    public List<Trolley> selectTrolleyOrders(String orders_number) throws SQLException {
        String sql = "select * from trolley where orders_number = ?";
        List<Trolley> trolleyList = JDBCutils.qr.query(sql, new BeanListHandler<Trolley>(Trolley.class), orders_number);
        return trolleyList;
    }
}
