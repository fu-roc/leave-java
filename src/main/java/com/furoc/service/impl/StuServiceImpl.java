package com.furoc.service.impl;

import com.furoc.mapper.StuMapper;
import com.furoc.pojo.*;
import com.furoc.service.StuService;
import com.furoc.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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
    获取离校请假信息
     */
    public List<LeaveCampusVo> getLeaveRecord(Integer uid, int id) {
//        获取审核中的请假记录
        if (id == 1) {
            List<LeaveCampusVo> leaveHistory = stuMapper.getLeaveHistory(uid);
            return leaveHistory;
        } else {
            List<LeaveCampusVo> leaveWorking = stuMapper.getLeaveWorking(uid);
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
    public boolean leaveApply(LeaveCampus leaveInfo) {
        int i = stuMapper.leaveApply(leaveInfo);
        return i > 0 ? true : false;
    }

    /*
    查询该学生所有课程
     */
    public List<ClessonVo> getAllCourse(Integer uid) {
        List<ClessonVo> allCourse = stuMapper.getAllCourse(uid);
        return allCourse;
    }

    /*
    课程请假申请
     */
    public boolean courseApply(LessonLeave lessonLeave) {
        int i = stuMapper.courseApply(lessonLeave);
        return i > 0 ? true : false;
    }

    /*
    获取请假信息
     */
    public List<LessonLeaveVo> getCourseRecord(Integer uid, int id) {
        //        获取已经有结果的请假记录
        if (id == 1) {
            List<LessonLeaveVo> courseHistory = stuMapper.getCourseHistory(uid);
            return courseHistory;
        } else if (id == 0){
            List<LessonLeaveVo> courseWorking = stuMapper.getCourseWorking(uid);
            return courseWorking;
        } else return null;
    }

    /*
    学生查看二课的申请情况,1为获取历史,0为获取审核中
     */
    public ArrayList<SecondScoreVo> getApplyProcess(Integer id,Integer uid) {
        ArrayList<SecondScoreVo> process = new ArrayList<>();
        if (id == 1) {
            process = stuMapper.getHistoryProcess(uid);
        } else if(id == 0) {
            process = stuMapper.getApplyProcess(uid);
        }
        return process;
    }

    /*
    获取所有教室信息
     */
    public ArrayList<Room> getAllRoomInfo() {
        ArrayList<Room> allRoomInfo = stuMapper.getAllRoomInfo();
        return allRoomInfo;
    }

    /*
    获取某个id教室的是否空闲信息
     */
    public ArrayList<RoomVo> getFreeRoomInfo(RoomVo roomVo) {
        ArrayList<RoomVo> freeRoomInfo = stuMapper.getFreeRoomInfo(roomVo);
        return freeRoomInfo;
    }

    /*
    获取时间表
     */
    public ArrayList<TimeInfo> getTimeTable() {
        ArrayList<TimeInfo> timeTable = stuMapper.getTimeTable();
        return timeTable;
    }

    /*
    教室申请，前端传roid,starttime,endtime,apply,choice[1,2,4,5,10,11,12]
     */
    public void saveClassApply(RoomApplicationVo roomApplication) {
        int[] choice = roomApplication.getChoice();
        int starTime = choice[0];
        for(int i = 0; i < choice.length; i++) {
            if (i == choice.length - 1) {
                roomApplication.setStarttime(starTime);
                roomApplication.setEndtime(choice[i]);
                stuMapper.saveClassApply(roomApplication);
                break;
            }
            if (choice[i + 1] == choice[i] + 1) {
            } else {
                roomApplication.setStarttime(starTime);
                roomApplication.setEndtime(choice[i]);
                stuMapper.saveClassApply(roomApplication);
                starTime = choice[i + 1];
            }
        }
    }

    /*
    获取所有开课记录
     */
    public ArrayList<ClessonVo> getAllClasses(Integer uid) {
        ArrayList<ClessonVo> allClasses = stuMapper.getAllClasses(uid);
        return allClasses;
    }

    /*
    查看申请的教室
     */
    public ArrayList<RoomApplicationVo> getAllRoom(Integer uid) {
        ArrayList<RoomApplicationVo> allRoom = stuMapper.getAllRoom(uid);
        return allRoom;
    }

    /*
    学生选课，前端传ccuid
     */
    public boolean saveClassById(Integer ccuid, Integer uid) {
        int i = stuMapper.saveClassById(ccuid, uid);
        return i > 0 ? true : false;
    }

    /*
    学生选课退选
     */
    public void removeClassById(Integer ccuid) {
        stuMapper.removeClassById(ccuid);
    }


    @Override
    public int updateHeadPic(Integer id, String imgName) {
        return stuMapper.updateHeadPic(id, imgName);
    }

    @Override
    public String getSecondScoreProof(Integer id) {
        return stuMapper.getSecondScoreProof(id);
    }

    @Override
    public boolean updateProol(String imgName, Integer id) {
        return stuMapper.updateProol(imgName, id);
    }

    @Override
    public String getFreeProof(Integer id) {
        return stuMapper.getFreeProof(id);
    }

    @Override
    public boolean updateFreeProol(String imgName, Integer id) {
        return stuMapper.updateFreeProol(imgName, id);
    }

    /**
     * 学生申请二课成绩
     */
    @Override
    public boolean secondScoreApply(SecondScore secondScore) {
        int i = stuMapper.secondScoreApply(secondScore);
        return i > 0;
    }

    /**
     * 学生免听免修申请
     */
    @Override
    public boolean freeApply(Free free) {
        int i = stuMapper.freeApply(free);
        return i > 0;
    }

    /*
    获取免听免修申请历史记录,1为获取历史,0为获取审核中
     */
    public ArrayList<FreeVo> getFreeRecord(Integer id,Integer uid) {
        ArrayList<FreeVo> freeVos = new ArrayList<>();
        if (id == 1) {
            freeVos = stuMapper.getFreeHistory(uid);
        } else if (id == 0){
            freeVos = stuMapper.getFreeWorking(uid);
        }
        return freeVos;
    }

}
