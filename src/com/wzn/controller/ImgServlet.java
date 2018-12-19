package com.wzn.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
@WebServlet("/img")
public class ImgServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part=req.getPart("file");//获取上传文件
        System.out.println(part.getSubmittedFileName());
        /*文件上传后的存储路径和名称*/
        String str="C:\\Users\\wzn\\cookieTest\\web\\img\\"+part.getSubmittedFileName();
        File file=new File(str);
        String url=str.substring(str.indexOf("img"));//截取img后边的路径
        System.out.println(url);
        /*输出流向指定位置写数据*/
        OutputStream os=new FileOutputStream(file);
        byte[]b=new byte[1024];
        InputStream is= part.getInputStream();
        int a = is.read(b,0,b.length);
        while(a!=-1){
            os.write(b);
           a=is.read(b,0,b.length);
        }



    }
}
