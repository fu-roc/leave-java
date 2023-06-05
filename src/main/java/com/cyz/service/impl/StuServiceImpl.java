package com.cyz.service.impl;

import com.cyz.entity.*;
import com.cyz.mapper.StuMapper;
import com.cyz.service.StuService;
import com.cyz.vo.AttendanceVo;
import com.cyz.vo.LeLeaveVo;
import com.cyz.vo.LeaveInfoVo;
import com.cyz.vo.StuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Autowired
    private StuMapper stuMapper;

    /*
    获取自己基础信息
     */
    public StuVo getStuInfo(Integer uid) {
        StuVo stuInfo = stuMapper.getStuInfo(uid);
        return stuInfo;
    }


    /*
    获取请假信息
     */
    public List<LeaveInfoVo> getLeaveRecord(Integer uid, int id) {
//        获取已经有结果的请假记录
        if (id == 1) {
            List<LeaveInfoVo> leaveHistory = stuMapper.getLeaveHistory(uid);
            return leaveHistory;
        } else {
            List<LeaveInfoVo> leaveWorking = stuMapper.getLeaveWorking(uid);
            return leaveWorking;
        }
    }

    /*
    出勤记录查看
    */
    public List<AttendanceVo> getAllAttendance(Integer uid) {
        List<AttendanceVo> allAttendance = stuMapper.getAllAttendance(uid);
        return allAttendance;
    }


    /*
    点名详细记录查看
     */
    public List<Attendance> getDetailAttendance(Integer uid, Integer cuid) {
        List<Attendance> detailAttendance = stuMapper.getDetailAttendance(uid, cuid);
        return detailAttendance;
    }

    /*
    获取辅导员id
     */
    public Teacher getInstId(Integer uid) {
        Teacher instId = stuMapper.getInstId(uid);
        return instId;
    }

    /*
    离校请假申请
     */
    public boolean leaveApply(LeaveInfo leaveInfo) {
        int i = stuMapper.leaveApply(leaveInfo);
        return i > 0 ? true : false;
    }

    /*
    查询该学生所有课程
     */
    public List<Lesson> getAllCourse(Integer uid) {
        List<Lesson> allCourse = stuMapper.getAllCourse(uid);
        return allCourse;
    }

    /*
    课程请假申请
     */
    public boolean courseApply(LeLeave leLeave) {
        int i = stuMapper.courseApply(leLeave);
        return i > 0 ? true : false;
    }

    /*
    获取请假信息
     */
    public List<LeLeaveVo> getCourseRecord(Integer uid, int id) {
        //        获取已经有结果的请假记录
        if (id == 1) {
            List<LeLeaveVo> courseHistory = stuMapper.getCourseHistory(uid);
            return courseHistory;
        } else {
            List<LeLeaveVo> courseWorking = stuMapper.getCourseWorking(uid);
            return courseWorking;
        }
    }
}
