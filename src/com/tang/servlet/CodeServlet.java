package com.tang.servlet;

import com.tang.utils.VerifyCodeUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author weepppp 2022/6/13 10:43
 * @version V1.0
 * @since
 **/
@WebServlet(name = "codeServlet", urlPatterns = "/codeServlet")
public class CodeServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        String code = VerifyCodeUtils.generateVerifyCode(4);
        HttpSession session = req.getSession();
        session.setAttribute("code",code);
        int w = 200;
        int h = 80;
        VerifyCodeUtils.outputImage(w,h,resp.getOutputStream(),code);
    }
}
