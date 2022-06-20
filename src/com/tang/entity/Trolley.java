package com.tang.entity;

/**
 * @author weepppp 2022/6/14 14:55
 * @version V1.0
 * @since
 **/
public class Trolley {
    private int tid;
    private int uid;
    private int pid;
    private int number;
    private String orders_number;
    private Product product;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Trolley() {
    }

    public Trolley(int tid, int uid, int pid, int number, String orders_number) {
        this.tid = tid;
        this.uid = uid;
        this.pid = pid;
        this.number = number;
        this.orders_number = orders_number;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getOrders_number() {
        return orders_number;
    }

    public void setOrders_number(String orders_number) {
        this.orders_number = orders_number;
    }
}
