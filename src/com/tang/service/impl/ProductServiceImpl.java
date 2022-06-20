package com.tang.service.impl;

import com.tang.dao.ProductDao;
import com.tang.dao.impl.ProductDaoImpl;
import com.tang.entity.Product;
import com.tang.entity.User;
import com.tang.service.ProductService;
import com.tang.utils.PageUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 11:00
 * @version V1.0
 * @since
 **/
public class ProductServiceImpl implements ProductService {
    private ProductDao productDao = new ProductDaoImpl();
    @Override
    public List<Product> selectByState(Integer state) throws SQLException {
        return productDao.selectByState(state);
    }

    @Override
    public List<Product> selectByName(String name) throws SQLException {
        return productDao.selectByName(name);
    }

    @Override
    public Product selectById(Integer sid) throws SQLException {
        return productDao.selectById(sid);
    }

    @Override
    public PageUtils<Product> selectByPage(String name, Integer state, String startTime, String endTime, String currentPage, String eachPage) {
        Integer currentPage1 = null;
        Integer eachPage1 = null;
        if (currentPage == null || "".equals(currentPage)) {
            currentPage1 = 1;
        } else {
            currentPage1 = Integer.parseInt(currentPage);
        }
        if (eachPage == null || "".equals(eachPage)) {
            eachPage1 = 2;
        } else {
            eachPage1 = Integer.parseInt(eachPage);
        }
        Integer totalPageSum = productDao.selectCount(name, state, startTime, endTime);
        Integer totalPageSize = totalPageSum % 2 == 0 ? totalPageSum / eachPage1 : totalPageSum / eachPage1 + 1;
        List<Product> userList = productDao.selectByPage(name,state,startTime,endTime,currentPage1,eachPage1);
        PageUtils<Product> pageUtils = new PageUtils<>();
        pageUtils.setUlist(userList);
        pageUtils.setEachPage(eachPage1);
        pageUtils.setCurrentPage(currentPage1);
        pageUtils.setTotalPageSize(totalPageSize);
        pageUtils.setTotalPageSum(totalPageSum);
        return pageUtils;
    }
}
