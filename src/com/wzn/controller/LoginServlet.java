package com.wzn.controller;  /*这个包存放界面控制的java代码*/

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*启动服务器在浏览器loginhttp://localhost:8080/jmyprojecty3_war_exploded/login会通
* 过web.xml找到这个java类，通过转发找到login.jsp界面。
* */
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println(req.getParameter("username"));  //获取name的内容
        /*转发*/
        req.getRequestDispatcher("WEB-INF/pages/login.jsp").forward(req,resp);
    }
}
