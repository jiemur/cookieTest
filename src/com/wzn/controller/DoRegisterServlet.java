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

@WebServlet("/doRegister")
public class DoRegisterServlet extends HttpServlet {   //验证是否能注册
    private IUserService service = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //System.out.println("哈哈哈");  //测试语句
        String uname = req.getParameter("unames");  /*不刷新时输入的数据*/
        String pwd = req.getParameter("pwd");
        String pwds = req.getParameter("pwds");
        String tele = req.getParameter("tele");
        /*System.out.println(uname);   //测试
        System.out.println(pwd + " " + pwds);  //测试
        System.out.println(tele);  //测试*/
        if (uname!=""){    //判断用户名输入不为空
            User user = service.getOne(uname);
            /*System.out.println(user);  //测试*/
            if (user == null){    //用户名可以使用
                resp.getWriter().write("1");
                if (pwd!=""&&pwds!=""){   //密码不为空
                    if (pwd.equals(pwds)){  //密码相同
                        resp.getWriter().write("3");  //不刷新时传出数据
                    }else {    //密码不相等
                        resp.getWriter().write("4");
                    }
                }else {     //密码为空
                    resp.getWriter().write("5");
                }
            }else {   //用户名以存在
                resp.getWriter().write("2");  //不刷新时传出数据
            }
        }
    }
}
