package com.furoc.controller;

import com.furoc.controller.utils.Result;
import com.furoc.pojo.*;
import com.furoc.service.StuService;
import com.furoc.utils.JwtUtils;
import com.furoc.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/stu")
public class StuController {
    private StuService stuService;
    @Autowired
   public void setStuService(StuService stuService) {
        this.stuService = stuService;
    }

    /*
    获取自己基础信息
     */
    @GetMapping
    public Result getStuInfo(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        StuVo stuInfo = stuService.getStuInfo(uid);
        return stuInfo != null ? Result.success(stuInfo) : Result.error("查询基础信息失败");
    }

    /*
    离校请假申请，前端传：开始时间、截止时间、目的地、原因
     */
    @PostMapping
    public Result leaveApply(HttpServletRequest req, @RequestBody LeaveCampus leaveInfo) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        leaveInfo.setSid(uid);
        boolean apply = stuService.leaveApply(leaveInfo);
        return apply ? Result.success(null) : Result.error("离校申请失败");
    }

    /*
    获取辅导员id和姓名
     */
    @GetMapping("/inst")
    public Result getInstId(HttpServletRequest req){
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        System.out.println("uid = " + uid);
        Teacher instId = stuService.getInstId(uid);
        return instId != null ? Result.success(instId) : Result.error("获取辅导员id失败");
    }

    /*
    课程请假申请，前端传cuid和请假日期
     */
    @PostMapping("courseApply")
    public Result courseApply(HttpServletRequest req ,@RequestBody LessonLeave lessonLeave) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        lessonLeave.setSid(uid);
        boolean apply = stuService.courseApply(lessonLeave);
        return apply ? Result.success(null) : Result.error("课程请假失败");
    }

    /*
    该学生所有课程展示
     */
    @GetMapping("allCourse")
    public Result getAllCourse(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<ClessonVo> allCourse = stuService.getAllCourse(uid);
        return allCourse != null ? Result.success(allCourse) : Result.error("获取学生所选课程失败");
    }

    /*
    离校请假记录获取,id=1为获取历史请假,id=0为获取审核中请假
     */
    @GetMapping(value = "/record/{id}")
    public Result getLeaveRecord(HttpServletRequest req, @PathVariable Integer id) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<LeaveCampusVo> allLeave = stuService.getLeaveRecord(uid, id);
        return allLeave != null ? Result.success(allLeave) : Result.error("获取离校请假信息失败");
    }

    /*
    课程请假记录获取,1为获取历史请假,0为获取审核中请假
     */
    @GetMapping("/courseRecord/{id}")
    public Result getCourseRecord(HttpServletRequest req, @PathVariable Integer id) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<LessonLeaveVo> allLeave = stuService.getCourseRecord(uid, id);
        return allLeave != null ? Result.success(allLeave) : Result.error("获取课程信息失败");
    }

    /*
    出勤记录查看
     */
    @GetMapping("/attend")
    public Result getAllAttendance(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<AttendanceVo> allAttendance = stuService.getAllAttendance(uid);
        return allAttendance != null ? Result.success(allAttendance) : Result.error("获取出勤记录失败");
    }

    /*
    点名详细记录查看
     */
    @GetMapping("/detail/{cuid}")
    public Result getDetailAttendance(HttpServletRequest req,@PathVariable Integer cuid) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<Attendance> detailAttendance = stuService.getDetailAttendance(uid,cuid);
        return detailAttendance != null ? Result.success(detailAttendance) : Result.error("获取点名详情失败");
    }

    /*
    学生查看二课的申请情况,1为获取历史请假,0为获取审核中请假
     */
    @GetMapping("/process/{id}")
    public Result getApplyProcess(HttpServletRequest req,@PathVariable Integer id) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        ArrayList<SecondScoreVo> applyProcess = stuService.getApplyProcess(id, uid);
        return applyProcess != null ? Result.success(applyProcess) : Result.error("获取二课数据失败");
    }

    /*
    获取所有教室信息
     */
    @GetMapping("/room")
    public Result getAllRoomInfo() {
        ArrayList<Room> allRoomInfo = stuService.getAllRoomInfo();
        return allRoomInfo != null ? Result.success(allRoomInfo) : Result.error("获取所有教室信息失败");
    }

    /*
    获取某个id教室的是否空闲信息，前端传使用日期，教室roid
     */
    @GetMapping("/room/free/{date}/{roid}")
    public Result getFreeRoomInfo(@PathVariable Date date,@PathVariable Integer roid) {
        RoomVo roomVo = new RoomVo();
        roomVo.setDate(date);
        roomVo.setRoid(roid);
//        获取星期几数据
        SimpleDateFormat weekFormat = new SimpleDateFormat("EEEE");
        roomVo.setWeek(weekFormat.format(roomVo.getDate()));
        ArrayList<RoomVo> freeRoomInfo = stuService.getFreeRoomInfo(roomVo);
        return freeRoomInfo != null ? Result.success(freeRoomInfo) : Result.error("获取教室的空闲信息失败");
    }

    /*
    教室申请，前端传roid,starttime,endtime,apply
     */
    @PostMapping("/room/apply")
    public Result saveClassApply(HttpServletRequest req, @RequestBody RoomApplicationVo roomApplication) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        roomApplication.setSid(uid);
        stuService.saveClassApply(roomApplication);
        return Result.success(null);
    }

    /*
    获取时间表
     */
    @GetMapping("/time")
    public Result getTimeTable() {
        ArrayList<TimeInfo> timeTable = stuService.getTimeTable();
        return timeTable!= null? Result.success(timeTable) : Result.error("获取时间表失败");
    }

    /*
    获取除已选的课程以外的所有开课记录
     */
    @GetMapping("/all/course")
    public Result getAllClasses(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        ArrayList<ClessonVo> allClasses = stuService.getAllClasses(uid);
        return allClasses != null ? Result.success(allClasses) : Result.error("获取所有开课记录失败");
    }

    /*
    查看申请的教室
     */
    @GetMapping("/room/all")
    public Result getAllRoom(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        ArrayList<RoomApplicationVo> allRoom = stuService.getAllRoom(uid);
        return allRoom != null ? Result.success(allRoom) : Result.error("获取申请的教室失败");
    }

    /*
    学生选课，前端传ccuid
     */
    @PostMapping("/select/course/{ccuid}")
    public Result saveClassById(HttpServletRequest req, @PathVariable Integer ccuid) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        boolean result = stuService.saveClassById(ccuid, uid);
        return result ? Result.success(null) : Result.error("选课失败");
    }

    /*
    学生选课退选
     */
    @DeleteMapping("/withdraw/{ccuid}")
    public Result removeClassById(@PathVariable Integer ccuid) {
        stuService.removeClassById(ccuid);
        return Result.success(null);
    }

    /**
     * 学生二课成绩申请
     */
    @PostMapping("/secondScoreApply")
    public Result secondScoreApply(HttpServletRequest req, @RequestBody SecondScore secondScore) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        secondScore.setSid(uid);
        Teacher instId = stuService.getInstId(uid);
        secondScore.setTid(instId.getTid());
        boolean apply = stuService.secondScoreApply(secondScore);
        return apply ? Result.success(null) : Result.error("二课申请失败");
    }

    /**
     * 免听免修申请
     */
    @PostMapping("/freeApply")
    public Result freeApply(HttpServletRequest req, @RequestBody Free free) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        free.setSid(uid);
        boolean apply = stuService.freeApply(free);
        return apply ? Result.success(null) : Result.error("免听免修申请失败");
    }

    /*
    获取免听免修申请历史记录,1为获取历史,0为获取审核中
     */
    @GetMapping("/record/free/{id}")
    public Result getFreeRecord(@PathVariable Integer id, HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        ArrayList<FreeVo> freeRecord = stuService.getFreeRecord(id, uid);
        return freeRecord != null ? Result.success(freeRecord) : Result.error("获取免听免修申请记录失败");
    }

}
