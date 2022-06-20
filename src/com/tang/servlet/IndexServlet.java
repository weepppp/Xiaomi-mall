package com.tang.servlet;

import com.tang.entity.Category;
import com.tang.entity.Product;
import com.tang.entity.User;
import com.tang.service.CategoryService;
import com.tang.service.ProductService;
import com.tang.service.TrolleyService;
import com.tang.service.impl.CategoryServiceImpl;
import com.tang.service.impl.ProductServiceImpl;
import com.tang.service.impl.TrolleyServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 9:39
 * @version V1.0
 * @since
 **/
@WebServlet(name = "indexServlet",urlPatterns = "/indexServlet")
public class IndexServlet extends BaseServlet {
    private CategoryService categoryService = new CategoryServiceImpl();
    private ProductService productService = new ProductServiceImpl();
    private TrolleyService trolleyService = new TrolleyServiceImpl();

    public void showInfoIndex(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        List<Category> categoryList = categoryService.selectByeachPage(10);
        System.out.println(categoryList.toArray());
        request.setAttribute("categoryList",categoryList);
        List<Product> productList = productService.selectByState(2);
        request.setAttribute("productList",productList);
        List<Product> proList = productService.selectByName("家电");
        request.setAttribute("proList",proList);

        int uid = ((User) request.getSession().getAttribute("user")).getId();
        Integer count = trolleyService.selectCount(uid);
        request.setAttribute("count",count);

        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
