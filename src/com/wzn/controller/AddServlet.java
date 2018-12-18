package com.wzn.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")  /*有这个注解,不需要通过web.xml也能到这个java类*/
/*@WebServlet(value = "/add")  这个跟上面一样*/
public class AddServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*跳转*/
        req.getRequestDispatcher("WEB-INF/pages/Add.jsp").forward(req,resp);
    }
}
