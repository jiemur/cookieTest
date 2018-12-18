package com.wzn.dao;  /*这个包存放的是对数据库操作*/



import com.wzn.pojo.User;
import com.wzn.utilTest.JdbcUtil;
import com.wzn.utilTest.RowMap;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaolmpl implements IUserDao {
    @Override
    public int insert(User user) {  //插入数据的方法实现
        return JdbcUtil.executeUpdate("insert into user(username,password,tele) values(?,?,?)",user.getUsername(),user.getPassword(),user.getTele());
    }

    @Override
    public User getOne(String username) {
        return JdbcUtil.queryOne("select username,password,tele from user where username=?", new RowMap<User>() {
            @Override
            public User rowMapping(ResultSet rs) {
                User u = new User();
                try {
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setTele(rs.getString("tele"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return u;
            }
        }, username);
    }
}
