package com.tang.entity;

import java.util.Date;

/**
 * @author weepppp 2022/6/14 10:35
 * @version V1.0
 * @since
 **/
public class Product {
    private int pid;
    private int cid;
    private String name;
    private String color;
    private String size;
    private double price;
    private String description;
    private String full_description;
    private String pic;
    private int state;
    private String version;
    private Date product_date;

    private String cname;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Product() {
    }

    public Product(int pid, int cid, String name, String color, String size, double price, String description, String full_description, String pic, int state, String version, Date product_date) {
        this.pid = pid;
        this.cid = cid;
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
        this.description = description;
        this.full_description = full_description;
        this.pic = pic;
        this.state = state;
        this.version = version;
        this.product_date = product_date;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getProduct_date() {
        return product_date;
    }

    public void setProduct_date(Date product_date) {
        this.product_date = product_date;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid=" + pid +
                ", cid=" + cid +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", full_description='" + full_description + '\'' +
                ", pic='" + pic + '\'' +
                ", state=" + state +
                ", version='" + version + '\'' +
                ", product_date=" + product_date +
                '}';
    }
}
