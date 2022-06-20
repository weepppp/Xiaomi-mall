package com.tang.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author weepppp 2022/6/13 11:53
 * @version V1.0
 * @since
 **/
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");
        try {
            String mark = req.getParameter("mark");
            if (mark == null || "".equals(mark)) {
                throw new RuntimeException("需要传递一个方法的名称");
            }
            Class aClass = this.getClass();
            Method method = aClass.getMethod(mark, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
