package com.furoc.service.impl;

import com.furoc.mapper.TeacherMapper;
import com.furoc.mapper.UserMapper;
import com.furoc.pojo.Teacher;
import com.furoc.service.UserService;
import com.furoc.vo.UpdateDTO;
import com.furoc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TeacherMapper teacherMapper;

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

    /*
    修改用户信息
     */
    public Teacher getByTid(int uid) {
        Teacher teacher = teacherMapper.selectTeaByTid(uid);
        return teacher;
    }

    public int updateUserInfo(UpdateDTO updateDTO, int id) {
        if (id == 0) {
            //student
            return userMapper.updateStu(updateDTO);
        } else if (id == 1) {
            //teacher
            return userMapper.updateTea(updateDTO);
        } else {
            throw new RuntimeException("错误的修改条件");
        }
    }
}
