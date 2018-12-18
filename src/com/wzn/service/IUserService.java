package com.wzn.service; /*这个包是逻辑处理*/


import com.wzn.pojo.User;

public interface IUserService {
    public int insert(User user);  //插入数据的方法
    public User getOne(String username);
}
