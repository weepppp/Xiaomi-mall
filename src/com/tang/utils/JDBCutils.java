package com.tang.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author weepppp 2022/5/30 14:50
 * @version V1.0
 * @since
 **/
public class JDBCutils {
    public static QueryRunner qr;

    static {
        try {
            Properties pro = new Properties();
            pro.load(new FileInputStream("D:\\testtesttesttesttesttesttesttesttesttest\\xiaomi_web\\src\\com\\tang\\utils\\druid.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
            qr = new QueryRunner(dataSource);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
