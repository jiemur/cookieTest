package com.wzn.controller;


import com.wzn.pojo.Product;
import com.wzn.service.IProductService;
import com.wzn.service.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/doUpdate")
public class DoUpdateServlet extends HttpServlet {
    IProductService service = new ProductServiceImpl();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        double price = Double.parseDouble(req.getParameter("price"));
        String des = req.getParameter("des");  //通过这个方法获取标签属性name的值
        String url = req.getParameter("url");
        Product p = new Product(id,name,price,des,url);
        //System.out.println(p);  //测试
        service.amend(p);
        /*重定向*/
        resp.sendRedirect("list");

    }
}