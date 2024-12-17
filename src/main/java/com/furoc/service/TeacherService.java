package com.furoc.service;

import com.furoc.pojo.Clesson;
import com.furoc.pojo.Lesson;
import com.furoc.pojo.Teacher;
import com.furoc.vo.LessonLeaveVo;
import com.furoc.vo.LessonVo;
import com.furoc.vo.TeachingVo;

import java.util.ArrayList;
import java.util.List;

public interface TeacherService {

    /**
     * 老师查询请假记录
     */
    List<LessonLeaveVo> queryleave(Integer tid, Integer id);

    /**
     * 查询所有的请假记录
     */
    List<LessonLeaveVo> queryAllLeave();

    /**
     * 老师信息的获取
     */
    Teacher info(Integer tid);

    Boolean findIsTea(Integer tid);

    int examine(Integer rid, String resultTea);

    int updateInfo(Teacher tea);

    Teacher findTeaById(Integer tid);

    int updateHeadPic(Integer tid, String imgName);

    /*
    查看自己教授的课程
     */
    public ArrayList<TeachingVo> teachCourse(Integer uid);

    /*
    教师选择星期几上课，前端传"教室id、星期几"
     */
    public ArrayList<Clesson> freeSection(Integer roid, String week);

    /*
    获取可以开课的课程列表
     */
    public ArrayList<Lesson> teachList();

    /*
    发布课程开课，前端传"cuid,roid,choice[],code,week"
     */
    public void teachSubmit(LessonVo lessonVo);
}