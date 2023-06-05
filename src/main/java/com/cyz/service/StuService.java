package com.cyz.service;

import com.cyz.entity.*;
import com.cyz.vo.AttendanceVo;
import com.cyz.vo.LeLeaveVo;
import com.cyz.vo.LeaveInfoVo;
import com.cyz.vo.StuVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface StuService {

    /*
    获取自己基础信息
     */
    public StuVo getStuInfo(Integer uid);

    /*
    获取请假信息
     */
    public List<LeaveInfoVo> getLeaveRecord(Integer uid, int id);

    /*
    出勤记录查看
     */
    public List<AttendanceVo> getAllAttendance(Integer uid);

    /*
    点名详细记录查看
     */
    public List<Attendance> getDetailAttendance(Integer uid, Integer cuid);

    /*
    获取辅导员id
     */
    public Teacher getInstId(Integer uid);

    /*
    离校请假申请
     */
    public boolean leaveApply(LeaveInfo leaveInfo);

    /*
    查询该学生所有课程
     */
    public List<Lesson> getAllCourse(Integer uid);

    /*
    课程请假申请
     */
    public boolean courseApply(LeLeave leLeave);

    /*
    获取请假信息
     */
    public List<LeLeaveVo> getCourseRecord(Integer uid, int id);

}
