package com.tang.utils;

import java.util.List;

/**
 * @author weepppp 2022/6/6 15:43
 * @version V1.0
 * @since
 **/
public class PageUtils<T> {
    private Integer currentPage;// 当前页码
    private Integer eachPage; // 当前页记录数
    private Integer totalPageSize; // 总页码
    private Integer totalPageSum; // 总记录数
    private List<T> ulist;

    public PageUtils() {
    }

    public PageUtils(Integer currentPage, Integer eachPage, Integer totalPageSize, Integer totalPageSum, List<T> ulist) {
        this.currentPage = currentPage;
        this.eachPage = eachPage;
        this.totalPageSize = totalPageSize;
        this.totalPageSum = totalPageSum;
        this.ulist = ulist;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getEachPage() {
        return eachPage;
    }

    public void setEachPage(Integer eachPage) {
        this.eachPage = eachPage;
    }

    public Integer getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(Integer totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public Integer getTotalPageSum() {
        return totalPageSum;
    }

    public void setTotalPageSum(Integer totalPageSum) {
        this.totalPageSum = totalPageSum;
    }

    public List<T> getUlist() {
        return ulist;
    }

    public void setUlist(List<T> ulist) {
        this.ulist = ulist;
    }
}
