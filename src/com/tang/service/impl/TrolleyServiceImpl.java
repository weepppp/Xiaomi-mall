package com.tang.service.impl;

import com.tang.dao.ProductDao;
import com.tang.dao.TrolleyDao;
import com.tang.dao.impl.ProductDaoImpl;
import com.tang.dao.impl.TrolleyDaoImpl;
import com.tang.entity.Product;
import com.tang.entity.Trolley;
import com.tang.service.TrolleyService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 15:25
 * @version V1.0
 * @since
 **/
public class TrolleyServiceImpl implements TrolleyService {
    TrolleyDao trolleyDao = new TrolleyDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public int addTrolley(Trolley trolley) throws SQLException {
        int num = -1;
        Trolley trolley1 = trolleyDao.select(trolley.getUid(), trolley.getPid());
        if (trolley1 == null) {
            num = trolleyDao.addTrolley(trolley);
        } else {
            trolley.setNumber(trolley.getNumber()+trolley1.getNumber());
            num = trolleyDao.updateTrolley(trolley);
        }
        return num;

    }

    @Override
    public Integer selectCount(Integer uid) throws SQLException {
        return trolleyDao.selectCount(uid);
    }

    @Override
    public List<Trolley> selectTrolley(Integer uid) throws SQLException {
        List<Trolley> trolleys = trolleyDao.selectTrolley(uid);
        for(Trolley t:trolleys) {
            int pid = t.getPid();
            Product product = productDao.selectById(pid);
            t.setProduct(product);
        }
        return trolleys;
    }

    @Override
    public Integer deleteById(String tid) throws SQLException {
        return trolleyDao.deleteById(tid);
    }

    @Override
    public Integer updateTrolley(int uid, String orders_number) throws SQLException {
        return trolleyDao.updateTrolley(uid,orders_number);
    }

    @Override
    public List<Trolley> selectTrolleyOrders(int uid) throws SQLException {
        List<Trolley> trolleys = trolleyDao.selectTrolleyOrders(uid);
        for(Trolley t:trolleys) {
            int pid = t.getPid();
            Product product = productDao.selectById(pid);
            t.setProduct(product);
        }
        return trolleys;
    }
}
