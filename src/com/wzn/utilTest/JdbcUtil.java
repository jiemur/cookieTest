package com.wzn.utilTest;  /*这个包存放工具*/

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/*除了Driver导com.mysql.jdbc包，其他的都导java.sql包。*/
public class JdbcUtil {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/user?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PWD = "123456";
    /*驱动*/
    static{
        try {
            new com.mysql.jdbc.Driver();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*定义一个方法  创建连接*/
    /*按着自己的需求 封装方法*/
    public static Connection getConnection(){
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(URL,USER,PWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    /*资源关闭方法*/
    public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(pstmt != null){
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    /*定义方法，增删改*/
    public static int executeUpdate(String sql, Object... obj){
        int a = 0;
        Connection conn = null;
        PreparedStatement pstmt = null;
        conn = getConnection();
        try {
            /*创建窗口*/
            pstmt = conn.prepareStatement(sql);
            if(obj != null){
                for (int i=0; i<obj.length; i++){
                    /*指定位置*/
                    pstmt.setObject(i+1,obj[i]);
                }
            }
            /*执行，返回受影响的行数*/
            a = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            close(null,pstmt,conn);
        }
        return a;
    }
    /*定义方法，查找*/
    public static <T> List<T> executQuery(String sql,RowMap<T> rm, Object... obj) {
        //范型
        List<T> lists = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if (obj != null) {
                for (int i = 0; i < obj.length; i++) {
                    pstmt.setObject(i + 1, obj[i]);
                }
            }
            rs = pstmt.executeQuery();

            while (rs.next()) {
                T t = rm.rowMapping(rs);
                lists.add(t);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, conn);//关闭通道
        }
        return lists;
    }
    /*定义方法，获取一个对象*/
    public static <T> T queryOne(String sql,RowMap<T> rm, Object... obj){ //范型
        T t = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        conn = getConnection();
        try {
            pstmt = conn.prepareStatement(sql);
            if(obj != null){
                for(int i=0; i<obj.length; i++){
                    pstmt.setObject(i+1,obj[i]);
                }
            }
            rs = pstmt.executeQuery();
            while(rs.next()){
                t = rm.rowMapping(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(rs, pstmt, conn);//关闭通道
        }
        return t;
    }
}