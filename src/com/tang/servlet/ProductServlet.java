package com.tang.servlet;

import com.tang.entity.Product;
import com.tang.service.ProductService;
import com.tang.service.impl.ProductServiceImpl;
import com.tang.utils.PageUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

/**
 * @author weepppp 2022/6/14 12:40
 * @version V1.0
 * @since
 **/
@WebServlet(name = "productServlet", urlPatterns = "/productServlet")
public class ProductServlet extends BaseServlet {
    ProductService productService = new ProductServiceImpl();

    public void selectById(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        String sid = request.getParameter("sid");
        Product product = productService.selectById(Integer.parseInt(sid));
        request.setAttribute("product", product);
        request.getRequestDispatcher("product_detail.jsp").forward(request, response);
    }

    public void showAdminProduct(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String currentPage = request.getParameter("currentPage");
        String eachPage = request.getParameter("eachPage");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");
        String name = request.getParameter("name");
        String stateStr = request.getParameter("state");
        Integer state = null;
        if (stateStr != null && !"".equals(stateStr)){
            state = Integer.parseInt(stateStr);
        }
        PageUtils<Product> pageUtils = productService.selectByPage(name, state, startTime, endTime, currentPage, eachPage);
        request.setAttribute("pageUtils", pageUtils);
        request.setAttribute("name",name);
        request.setAttribute("state", state);
        request.setAttribute("startTime", startTime);
        request.setAttribute("endTime", endTime);
        request.getRequestDispatcher("admin/product_list.jsp").forward(request, response);
    }

}
