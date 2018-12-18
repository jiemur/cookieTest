package com.wzn.dao;  /*这个包存放的是对数据库操作*/


import com.wzn.pojo.User;

public interface IUserDao {
    public int insert(User user);   //插入数据的方法
    public User getOne(String username);   //通过username获取一个User对象
}
