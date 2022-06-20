package com.tang.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author weepppp 2022/6/14 9:10
 * @version V1.0
 * @since
 **/
public class Category implements Serializable {
    private  int cid;
    private  String name;
    private  int state;
    private  int order_number;
    private String description;
    private Date create_time;



    public Category() {
    }

    public Category(int cid, String name, int state, int order_number, String description, Date create_time) {
        this.cid = cid;
        this.name = name;
        this.state = state;
        this.order_number = order_number;
        this.description = description;
        this.create_time = create_time;
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

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", name='" + name + '\'' +
                ", state=" + state +
                ", order_number=" + order_number +
                ", description='" + description + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
