package com.cyz.service.impl;

import com.cyz.mapper.UserMapper;
import com.cyz.service.UserService;
import com.cyz.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /*
    登录
     */
    public boolean login(UserVo user, int id) {
        int login;
        if (id == 0)
            login = userMapper.loginStu(user);
        else
            login = userMapper.loginTea(user);
        return login > 0 ? true : false;
    }

}
