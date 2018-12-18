package com.wzn.controller;  /*这个包存放界面控制的java代码*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/pages/register.jsp").forward(req,resp);
        /*String username = req.getParameter("username");  //获取name的内容
        String pwb = req.getParameter("pwd");
        String pwbs = req.getParameter("pwds");
        String tele = req.getParameter("tele");

        *//*注册成功，跳转登录界面*//*
        resp.sendRedirect("login");*/
    }
}
