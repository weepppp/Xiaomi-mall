package com.tang.servlet;

import com.tang.entity.Trolley;
import com.tang.entity.User;
import com.tang.service.TrolleyService;
import com.tang.service.impl.TrolleyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

/**
 * @author weepppp 2022/6/14 15:28
 * @version V1.0
 * @since
 **/
@WebServlet(name = "trolleyServlet",urlPatterns = "/trolleyServlet")
public class TrolleyServlet extends BaseServlet {
    private TrolleyService trolleyService = new TrolleyServiceImpl();
    public void addTrolley(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        PrintWriter printWriter = response.getWriter();
        String pid = request.getParameter("pid");
        String num = request.getParameter("num");
        int uid = ((User) request.getSession().getAttribute("user")).getId();
        Trolley trolley = new Trolley();
        trolley.setPid(Integer.parseInt(pid));
        trolley.setNumber(Integer.parseInt(num));
        trolley.setUid(uid);
        int i = trolleyService.addTrolley(trolley);
        if (i > 0) {
            printWriter.print("true");
        } else {
            printWriter.print("false");
        }
    }


    public void showTrolley(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        int uid = ((User) request.getSession().getAttribute("user")).getId();
        List<Trolley> trolleys = trolleyService.selectTrolley(uid);
        request.setAttribute("trolleys",trolleys);
        request.getRequestDispatcher("trolley.jsp").forward(request,response);
    }

    public void delectId(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException {
        PrintWriter printWriter = response.getWriter();
        String tid = request.getParameter("tid");
        Integer integer = trolleyService.deleteById(tid);
        if (integer > 0) {
            printWriter.print("true");
        } else {
            printWriter.print("false");
        }
    }
}
