package com.cyz.controller;

import com.cyz.controller.utils.Result;
import com.cyz.entity.*;
import com.cyz.service.StuService;
import com.cyz.utils.JwtUtils;
import com.cyz.vo.AttendanceVo;
import com.cyz.vo.LeLeaveVo;
import com.cyz.vo.LeaveInfoVo;
import com.cyz.vo.StuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * User: Zoc
 * Date: 2023/6/5
 * Time: 21:59
 */

@RestController
@RequestMapping("/stu")
public class StuController {

    @Autowired
    private StuService stuService;

    /*
    获取自己基础信息
     */
    @GetMapping
    public Result getStuInfo(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        StuVo stuInfo = stuService.getStuInfo(uid);
        return stuInfo != null ? Result.success(stuInfo) : Result.error("查询失败");
    }

    /*
    离校请假申请，前端传：开始时间、截止时间、目的地、原因
     */
    @PutMapping
    public Result leaveApply(HttpServletRequest req, @RequestBody LeaveInfo leaveInfo) {
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
        Teacher instId = stuService.getInstId(uid);
        return instId != null ? Result.success(instId) : Result.error("获取辅导员id失败");
    }

    /*
    课程请假申请，前端传cuid和请假日期
     */
    @PutMapping("courseApply")
    public Result courseApply(HttpServletRequest req ,@RequestBody LeLeave leLeave) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        leLeave.setSid(uid);
        boolean apply = stuService.courseApply(leLeave);
        return apply ? Result.success(null) : Result.error("课程请假失败");
    }

    /*
    该学生所有课程展示
     */
    @GetMapping("allCourse")
    public Result getAllCourse(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<Lesson> allCourse = stuService.getAllCourse(uid);
        return allCourse != null ? Result.success(allCourse) : Result.error("获取课程失败");
    }

    /*
    请假记录获取,id=0为获取历史请假,id=1为获取审核中请假
     */
    @RequestMapping(value = "/record/{id}")
    public Result getLeaveRecord(HttpServletRequest req, @PathVariable Integer id) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<LeaveInfoVo> allLeave = stuService.getLeaveRecord(uid, id);
        return allLeave != null ? Result.success(allLeave) : Result.error("获取失败");
    }

    /*
    课程请假记录获取,1为获取历史请假,0为获取审核中请假
     */
    @RequestMapping("/courseRecord/{id}")
    public Result getCourseRecord(HttpServletRequest req, @PathVariable Integer id) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<LeLeaveVo> allLeave = stuService.getCourseRecord(uid, id);
        return allLeave != null ? Result.success(allLeave) : Result.error("获取失败");
    }


    /*
    出勤记录查看
     */
    @RequestMapping("/attend")
    public Result getAllAttendance(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<AttendanceVo> allAttendance = stuService.getAllAttendance(uid);
        return allAttendance != null ? Result.success(allAttendance) : Result.error("获取失败");
    }


    /*
    点名详细记录查看
     */
    @RequestMapping("/detail/{cuid}")
    public Result getDetailAttendance(HttpServletRequest req,@PathVariable Integer cuid) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        List<Attendance> detailAttendance = stuService.getDetailAttendance(uid,cuid);
        return detailAttendance != null ? Result.success(detailAttendance) : Result.error("获取失败");
    }

}
