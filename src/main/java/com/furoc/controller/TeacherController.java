package com.furoc.controller;

import com.furoc.controller.utils.Result;
import com.furoc.pojo.Clesson;
import com.furoc.pojo.Lesson;
import com.furoc.pojo.LessonLeave;
import com.furoc.pojo.Teacher;
import com.furoc.service.TeacherService;
import com.furoc.utils.JwtUtils;
import com.furoc.vo.LessonLeaveVo;
import com.furoc.vo.LessonVo;
import com.furoc.vo.TeachingVo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Zoc
 * Date: 2023/6/7
 * Time: 10:09
 */
@RestController
@RequestMapping("/tea")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;

    }

    //查询请假,1为获取历史,0为获取审核中
    @GetMapping("/leLeave/{id}")
    public Result findLeaveInfo(@PathVariable Integer id, HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (teacherService.findIsTea(tid)) {
            List<LessonLeaveVo> data = teacherService.queryleave(tid,id);
            return Result.success(data);
        } else return Result.error("不是教师");
    }

    //老师个人信息 ------------3
    @GetMapping("/info")
    public Result findTeaInfo(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (teacherService.findIsTea(tid)) {
            Teacher data = teacherService.info(tid);
            return Result.success(data);
        } else return Result.error("不是教师");
    }

    //修改老师个人信息
    @PutMapping("/updateInfo")
    public Result updateTeaInfo(@RequestBody Teacher tea, HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (teacherService.findIsTea(tid)) {
            tea.setTid(tid);
            int row = teacherService.updateInfo(tea);
            if (row != 0) {
                return Result.success("更新成功");
            } else return Result.error("更新失败");
        } else return Result.error("不是教师");
    }

    //更新课程请假状态 ------------3
    @PutMapping("/examine")
    public Result examine(@RequestBody LessonLeave leLeave, HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (teacherService.findIsTea(tid)) {
            int row = teacherService.examine(leLeave.getRid(), leLeave.getResultTea());
            if (row != 0) {
                return Result.success("更新成功");
            } else return Result.error("更新失败");
        } else return Result.error("不是教师");
    }

    /**
     * 所有请课历史记录
     */
    @GetMapping("/leLeaveHistory")
    public Result LeLeaveHistory(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        if (teacherService.findIsTea(tid)) {
            List<LessonLeaveVo> data = teacherService.queryAllLeave();
            return Result.success(data);
        } else return Result.error("不是教师");
    }

    /*
    查看自己教授的课程
     */
    @GetMapping("/teach/course")
    public Result teachCourse(HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        ArrayList<TeachingVo> teachingVos = teacherService.teachCourse(tid);
        return  teachingVos != null ? Result.success(teachingVos): Result.error("没有查询到授课的课程");
    }

    /*
    教师选择星期几上课，前端传"教室id、星期几"
     */
    @GetMapping("/free/section")
    public Result freeSection(@RequestParam Integer roid, @RequestParam String week) {
        ArrayList<Clesson> clessons = teacherService.freeSection(roid, week);
        return clessons != null ? Result.success(clessons): Result.error("该天没有课程");
    }

    /*
    获取可以开课的课程列表
     */
    @GetMapping("/teach/list")
    public Result teachList() {
        ArrayList<Lesson> lessons = teacherService.teachList();
        return lessons != null ? Result.success(lessons) : Result.error("没有可以开课的课程");
    }

    /*
    TODO:发布课程开课，前端传"cuid,roid,choice[],code,week"
     */
    @PostMapping("/teach/submit")
    public Result teachSubmit(@RequestBody LessonVo lessonVo,HttpServletRequest req) {
        String token = req.getHeader("token");
        Integer tid = JwtUtils.parseJwt(token);
        lessonVo.setTid(tid);
        teacherService.teachSubmit(lessonVo);
        return Result.success(null);
    }

}
