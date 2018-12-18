package com.wzn.service;   /*这个包是逻辑处理*/


import com.wzn.dao.IUserDao;
import com.wzn.dao.UserDaolmpl;
import com.wzn.pojo.User;

public class UserServiceImpl implements IUserService {
    private IUserDao dao = new UserDaolmpl();
    @Override
    public int insert(User user) {   //去调用了一下dao层
        return dao.insert(user);
    }

    @Override
    public User getOne(String username) {
        return dao.getOne(username);
    }
}
