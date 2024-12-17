package com.furoc.service;

import com.furoc.pojo.*;
import com.furoc.vo.*;

import java.util.ArrayList;
import java.util.List;

public interface StuService {

    /*
    获取自己基础信息
     */
    public StuVo getStuInfo(Integer uid);

    /*
    获取请假信息
     */
    public List<LeaveCampusVo> getLeaveRecord(Integer uid, int id);

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
    public boolean leaveApply(LeaveCampus leaveInfo);

    /*
    查询该学生所有课程
     */
    public List<ClessonVo> getAllCourse(Integer uid);

    /*
    课程请假申请
     */
    public boolean courseApply(LessonLeave lessonLeave);

    /*
    获取请假信息
     */
    public List<LessonLeaveVo> getCourseRecord(Integer uid, int id);

    /*
    学生查看二课的申请情况,1为获取历史,0为获取审核中
     */
    public ArrayList<SecondScoreVo> getApplyProcess(Integer id,Integer uid);

    /*
    获取所有教室信息
     */
    public ArrayList<Room> getAllRoomInfo();

    /*
    获取某个id教室的是否空闲信息
     */
    public ArrayList<RoomVo> getFreeRoomInfo(RoomVo roomVo);

    /*
    获取时间表
     */
    public ArrayList<TimeInfo> getTimeTable();

    /*
    教室申请，前端传roid,starttime,endtime,apply
     */
    public void saveClassApply(RoomApplicationVo roomApplication);

    /*
    获取所有开课记录
     */
    public ArrayList<ClessonVo> getAllClasses(Integer uid);

    /*
    查看申请的教室
     */
    public ArrayList<RoomApplicationVo> getAllRoom(Integer uid);

    /*
    学生选课，前端传ccuid
     */
    public boolean saveClassById(Integer ccuid, Integer uid);

    /*
    学生选课退选
     */
    public void removeClassById(Integer ccuid);

    /**
     * 更新学生头像
     *
     * @param id
     * @param imgName
     * @return
     */
    int updateHeadPic(Integer id, String imgName);

    /**
     * 获取学生二课证明材料
     *
     * @param id
     * @return
     */
    String getSecondScoreProof(Integer id);

    /**
     * 更新二课证明材料
     *
     * @param imgName
     * @param id
     * @return
     */
    boolean updateProol(String imgName, Integer id);

    /**
     * 获取学生的免听免修证明材料
     *
     * @param id
     * @return
     */
    String getFreeProof(Integer id);

    /**
     * 更新学生免听免修证明材料
     *
     * @param imgName
     * @param id
     * @return
     */
    boolean updateFreeProol(String imgName, Integer id);

    /**
     * 申请二课成绩
     */
    boolean secondScoreApply(SecondScore secondScore);

    /**
     * 学生申请免听免修
     */
    boolean freeApply(Free free);

    /*
    获取免听免修申请历史记录,1为获取历史,0为获取审核中
     */
    public ArrayList<FreeVo> getFreeRecord(Integer id,Integer uid);

}
