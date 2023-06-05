package com.cyz.service.impl;

import com.cyz.mapper.TeacherMapper;
import com.cyz.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
//    @Autowired
//    private TeacherMapper teacherMapper;
//
//    /**
//     * 老师查询当天的请假记录
//     */
//    public List<HistoryInfo> queryleave(String tuid, String date, String uid, String uname) {
//        return teacherMapper.queryleave(tuid, date, uid, uname);
//    }
//
//    /**
//     * 查询所有的请假记录
//     */
//    public List<HistoryInfo> queryAllLeave(String tuid, String date, String uid, String uname) {
//        return teacherMapper.queryAllLeave(tuid, date, uid, uname);
//    }
//
//    /**
//     * 老师信息的获取
//     */
//    public StuBaseInfos info(String uid) {
//        return teacherMapper.info(uid);
//    }
}
