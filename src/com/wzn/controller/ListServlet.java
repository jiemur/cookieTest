package com.wzn.controller;

import com.wzn.pojo.Product;
import com.wzn.pojo.User;
import com.wzn.service.IProductService;
import com.wzn.service.IUserService;
import com.wzn.service.ProductServiceImpl;
import com.wzn.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListServlet extends HttpServlet {
    private IProductService service = new ProductServiceImpl();
    private IUserService userService=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies=req.getCookies();
        Map<String,Cookie> maps=getCookie(cookies);
        Cookie coo=maps.get("username");
        String uname=coo.getValue();
        HttpSession session=req.getSession();
        User u=(User) session.getAttribute("user");
        List<Product> lists=service.getLists();
        req.setAttribute("lists",lists);
        if(u==null){
            User user= userService.getOne(uname);
            session.setAttribute("user",user);
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("WEB-INF/pages/list.jsp").forward(req,resp);
        }

    }
    public static Map<String,Cookie> getCookie(Cookie[] cookies){
        Map<String,Cookie> maps=new HashMap<>();
        if(cookies!=null){
            for (Cookie c:cookies
                 ) {
                maps.put(c.getName(),c);
            }
        }
        return maps;
    }
}
