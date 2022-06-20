package com.tang.servlet;

import com.tang.entity.Orders;
import com.tang.entity.Trolley;
import com.tang.entity.User;
import com.tang.service.OrdersService;
import com.tang.service.TrolleyService;
import com.tang.service.impl.OrderServiceImpl;
import com.tang.service.impl.TrolleyServiceImpl;
import com.tang.utils.MD5Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author weepppp 2022/6/15 12:39
 * @version V1.0
 * @since
 **/
@WebServlet(name = "ordersServlet",urlPatterns = "/ordersServlet")
public class OrdersServlet extends BaseServlet {

    private OrdersService ordersService = new OrderServiceImpl();
    private TrolleyService trolleyService = new TrolleyServiceImpl();
    public void addOrders(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        PrintWriter printWriter = response.getWriter();
        Orders orders = new Orders();
        orders.setCreate_time(new Date());
        orders.setState(0);
        int uid = ((User) request.getSession().getAttribute("user")).getId();
        orders.setUid(uid);
        orders.setOrders_number(MD5Utils.encode(UUID.randomUUID()+"".replaceAll("-","")));
        List<Trolley> trolleys = trolleyService.selectTrolleyOrders(uid);
        orders.setCount_number(trolleys.size());
        double money = 0;
        if (trolleys != null && trolleys.size() > 0) {
            for(Trolley t : trolleys) {
                money+=(t.getNumber()*t.getProduct().getPrice());
            }
        } else {
            orders.setSum_price(1);
        }
        orders.setSum_price(money);
        Integer i = ordersService.addOrders(orders);
        if (i > 0) {
            printWriter.print("true");
        } else {
            printWriter.print("false");
        }
    }

    public void pay(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("pay/index.jsp").forward(request,response);
    }

    public void showOrders(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        int uid = ((User) request.getSession().getAttribute("user")).getId();
        List<Orders> ordersList = ordersService.selectById(uid);
        request.setAttribute("ordersList",ordersList);
        request.getRequestDispatcher("orders_history.jsp").forward(request,response);
    }

}
