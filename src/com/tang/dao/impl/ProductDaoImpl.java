package com.tang.dao.impl;

import com.tang.dao.ProductDao;
import com.tang.entity.Product;
import com.tang.utils.JDBCutils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author weepppp 2022/6/14 10:58
 * @version V1.0
 * @since
 **/
public class ProductDaoImpl implements ProductDao {
    @Override
    public List<Product> selectByState(Integer state) throws SQLException {
        String sql = "select * from product where state = ?";
        List<Product> list = JDBCutils.qr.query(sql, new BeanListHandler<Product>(Product.class), state);
        return list;
    }

    @Override
    public List<Product> selectByName(String name) throws SQLException {
        String sql = "select p.* from product p,category c where p.cid = c.cid and c.name = ?";
        List<Product> list = JDBCutils.qr.query(sql, new BeanListHandler<Product>(Product.class), name);
        return list;
    }

    @Override
    public Product selectById(Integer sid) throws SQLException {
        String sql = "select * from product where pid = ?";
        Product product = JDBCutils.qr.query(sql,new BeanHandler<Product>(Product.class),sid);
        return  product;
    }

    @Override
    public List<Product> selectByPage(String name, Integer state, String startTime
            , String endTime, Integer currentPage, Integer eachPage) {
        List<Product> productList= null;
        try {
            List<Object> pramList = new ArrayList<>();
            StringBuffer sb = new StringBuffer("select p.*,c.name cname from  category c,product p WHERE c.cid = p.cid");
                if (name !=null && !"".equals(name)) {
                    sb.append(" and p.name like ? ");
                    pramList .add("%"+name+"%");
                }
                if (state !=null) {
                    sb.append(" and p.state =?");
                    pramList.add(state);
                }

                if (startTime !=null && !"".equals(startTime)) {
                    sb.append(" and p.product_date > ?");
                    pramList.add(startTime);
                }

                if (endTime !=null && !"".equals(endTime)){
                    sb.append(" and p.product_date < ? ");
                    pramList.add(endTime);
                }
            sb.append(" limit ?,?");
            pramList.add((currentPage-1)*eachPage);
            pramList.add(eachPage);
            productList = JDBCutils.qr.query(sb.toString(),new BeanListHandler<Product>
                    (Product.class),pramList.toArray());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public Integer selectCount(String name, Integer state, String startTime, String endTime) {
        Long count= null;
        try {
            List<Object> pramList = new ArrayList<>();
            StringBuffer sb = new StringBuffer("SELECT count(1) FROM product p WHERE 1=1");
            if (name !=null && !"".equals(name)) {
                sb.append(" and p.name like ? ");
                pramList .add("%"+name+"%");
            }
            if (state !=null) {
                sb.append(" and p.state =?");
                pramList.add(state);
            }

            if (startTime !=null && !"".equals(startTime)) {
                sb.append(" and p.product_date > ?");
                pramList.add(startTime);
            }

            if (endTime !=null && !"".equals(endTime)){
                sb.append(" and p.product_date < ? ");
                pramList.add(endTime);
            }

            if (pramList !=null && pramList.size() >0) {
                count = (Long)JDBCutils.qr.query(sb.toString(),new ScalarHandler(),pramList.toArray());
            }else {
                count = (Long) JDBCutils.qr.query(sb.toString(),new ScalarHandler());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return count ==null ? 0 :Integer.parseInt(count+"");
    }

}
