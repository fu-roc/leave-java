package com.furoc.service;

import com.furoc.pojo.Teacher;
import com.furoc.vo.UpdateDTO;
import com.furoc.vo.UserVo;

public interface UserService {

    boolean login(UserVo user, int id);

    Teacher getByTid(int uid);

    int updateUserInfo(UpdateDTO updateDTO, int id);

}
