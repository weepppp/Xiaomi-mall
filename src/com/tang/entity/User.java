package com.tang.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author weepppp 2022/6/13 14:24
 * @version V1.0
 * @since
 **/
public class User implements Serializable {
    private int id;
    private String name;
    private int sex;
    private String phone_number;
    private String area;
    private int manager;
    private String username;
    private String password;
    private String photo;
    private Date create_time;

    public User() {
    }

    public User(int id, String name, int sex, String phone_number, String area, int manager, String username, String password, String photo, Date create_time) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.phone_number = phone_number;
        this.area = area;
        this.manager = manager;
        this.username = username;
        this.password = password;
        this.photo = photo;
        this.create_time = create_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getManager() {
        return manager;
    }

    public void setManager(int manager) {
        this.manager = manager;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
