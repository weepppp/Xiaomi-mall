package com.tang.servlet;

import com.tang.entity.User;
import com.tang.service.TrolleyService;
import com.tang.service.UserService;
import com.tang.service.impl.TrolleyServiceImpl;
import com.tang.service.impl.UserServiceImpl;
import com.tang.utils.MD5Utils;
import com.tang.utils.PageUtils;
import jdk.nashorn.internal.ir.CallNode;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * @author weepppp 2022/6/13 11:34
 * @version V1.0
 * @since
 **/
@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class UserServlet extends BaseServlet {
    UserService userService;
    TrolleyService trolleyService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        userService = new UserServiceImpl();
        trolleyService = new TrolleyServiceImpl();
    }

    public void checkedCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        String verify = request.getParameter("verify");
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute("code");
        if (code.equalsIgnoreCase(verify)) {
            printWriter.print("true");
        } else {
            printWriter.print("false");
        }
        printWriter.close();
    }

    public void checkLogin(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.selectByUsername(username, password);
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            int uid = ((User) request.getSession().getAttribute("user")).getId();
            Integer count = trolleyService.selectCount(uid);
            request.setAttribute("count",count);
            IndexServlet indexServlet = new IndexServlet();
            indexServlet.showInfoIndex(request,response);
        } else {
            request.setAttribute("msg", "用户名和密码不正确");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }


    public void checkedUsername(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        PrintWriter printWriter = response.getWriter();
        String username = request.getParameter("username");
        boolean b = userService.selectByUsername(username);
        printWriter.print(b);
        printWriter.close();
    }

    public void checkedPhoneNumber(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, SQLException {
        PrintWriter printWriter = response.getWriter();
        String phone_number = request.getParameter("phone_number");
        boolean b = userService.selectByPhoneNumber(phone_number);
        printWriter.print(b);
        printWriter.close();
    }

    public void register(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String realPath = request.getServletContext().getRealPath("WEB-INF/upload");
        File file = new File(realPath);
        if (!file.exists()) {
            file.mkdirs();
        }
        User user = new User();
        boolean saveFlag = false;
        boolean b = ServletFileUpload.isMultipartContent(request);
        if (b) {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            List<FileItem> list = upload.parseRequest(request);
            Iterator<FileItem> iterator = list.iterator();
            while (iterator.hasNext()) {
                FileItem next = iterator.next();
                if (next.isFormField()) {
                    String fieldName = next.getFieldName();
                    if ("name".equals(fieldName)) {
                        user.setName(next.getString("UTF-8"));
                    } else if ("sex".equals(fieldName)) {
                        user.setSex(Integer.parseInt(next.getString("UTF-8")));
                    } else if ("phone_number".equals(fieldName)) {
                        user.setPhone_number(next.getString("UTF-8"));
                    } else if ("area".equals(fieldName)) {
                        user.setArea(next.getString("UTF-8"));
                    } else if ("username".equals(fieldName)) {
                        user.setUsername(next.getString("UTF-8"));
                    } else if ("password".equals(fieldName)) {
                        user.setPassword(next.getString("UTF-8"));
                    }
                } else {
                    String name = next.getName();
                    if (!name.endsWith("jpg") || name.endsWith("png") || name.endsWith("gif")) {
                        request.setAttribute("msg", "图片格式不正确");
                        request.getRequestDispatcher("register.jsp").forward(request, response);
                    } else {
                        long time = System.currentTimeMillis();
                        name = MD5Utils.encode(time + "") + name;
                        user.setPhoto(name);
                        File file1 = new File(file, name);
                        next.write(file1);
                        saveFlag = true;
                        user.setCreate_time(new Date());
                    }
                }
            }

        } else {
            request.setAttribute("msg","请以图片的形式提交");
        }
        if (saveFlag) {
            if (userService.addUser(user) > 0) {
                response.sendRedirect("login.jsp");
            } else {
                request.setAttribute("msg","登录失败");
            }
        }
    }

    public void adminLoginIn(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.selectAdmin(username, password, 1);
        request.getSession().setAttribute("user", user);
        response.sendRedirect("admin/main.jsp");
    }

    public void showAdminUser(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        String currentPage = request.getParameter("currentPage");
        String eachPage = request.getParameter("eachPage");
        PageUtils<User> pageUtils = userService.selectAdmin(currentPage, eachPage);
        request.setAttribute("pageUtils",pageUtils);
        request.getRequestDispatcher("admin/user_list.jsp").forward(request,response);
    }

    public void updateManager(HttpServletRequest request,HttpServletResponse response) throws SQLException, ServletException, IOException {
        String id = request.getParameter("id");
        String manager = request.getParameter("manager");
        Integer integer = userService.updateManager(Integer.parseInt(id), Integer.parseInt(manager));
        showAdminUser(request,response);
    }

    public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException, SQLException {
        PrintWriter printWriter = response.getWriter();
        String id = request.getParameter("id");
        if(userService.deleteById(id,request)){
            printWriter.print("true");
        } else {
            printWriter.print("false");
        }
    }



}


