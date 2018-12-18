package com.wzn.controller;


import com.wzn.pojo.User;
import com.wzn.service.IUserService;
import com.wzn.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doIt")
public class DoItServlet extends HttpServlet {   //注册
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("unames");  /*不刷新时输入的数据*/
        String pwd = req.getParameter("pwd");
        String pwds = req.getParameter("pwds");
        String tele = req.getParameter("tele");
        /*System.out.println(uname);   //测试
        System.out.println(pwd + " " + pwds);  //测试
        System.out.println(tele);  //测试*/
        User u = new User();
        u.setUsername(uname);
        u.setPassword(pwd);
        u.setTele(tele);
        int result = service.insert(u); //存放到数据库，返回受影响条数
        if (result>0){
            resp.getWriter().write("1");
        }
    }
}
