package com.furoc.service.impl;

import com.furoc.mapper.TeacherMapper;
import com.furoc.pojo.Clesson;
import com.furoc.pojo.Lesson;
import com.furoc.pojo.Teacher;
import com.furoc.service.TeacherService;
import com.furoc.vo.LessonLeaveVo;
import com.furoc.vo.LessonVo;
import com.furoc.vo.TeachingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherServiceimpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 老师查询当天的请假记录
     */
    public List<LessonLeaveVo> queryleave(Integer tid, Integer id) {
        List<LessonLeaveVo> result = new ArrayList<>();
        if (id == 1) {
            result = teacherMapper.selectLeaveHistory(tid);
        } else if(id == 0) {
            result = teacherMapper.selectLeaveWorking(tid);
        }
        return result;
    }

    @Override
    public List<LessonLeaveVo> queryAllLeave() {
        return teacherMapper.selectAllLeaveInfo();
    }

    /**
     * 老师信息的获取
     */
    @Override
    public Teacher info(Integer tid) {
        return teacherMapper.selectByTid(tid);
    }

    @Override
    public Boolean findIsTea(Integer tid) {
        return teacherMapper.selectIsTea(tid);
    }

    @Override
    public int examine(Integer rid, String resultTea) {
        return teacherMapper.updateResultByRid(rid, resultTea);
    }

    @Override
    public Teacher findTeaById(Integer tid) {
        return teacherMapper.selectTeaByTid(tid);
    }

    @Override
    public int updateHeadPic(Integer tid, String imgName) {
        return teacherMapper.updateHeadPic(tid, imgName);
    }

    @Override
    public int updateInfo(Teacher tea) {
        return teacherMapper.updateInfo(tea);
    }

    /*
    查看自己教授的课程
     */
    public ArrayList<TeachingVo> teachCourse(Integer uid) {
        ArrayList<TeachingVo> teachingVos = teacherMapper.teachCourse(uid);
        return teachingVos;
    }

    /*
    教师选择星期几上课，前端传"教室id、星期几"
     */
    public ArrayList<Clesson> freeSection(Integer roid, String week) {
        ArrayList<Clesson> clessons = teacherMapper.freeSection(roid, week);
        return clessons;
    }

    /*
    获取可以开课的课程列表
     */
    public ArrayList<Lesson> teachList() {
        ArrayList<Lesson> lessons = teacherMapper.teachList();
        return lessons;
    }

    /*
    发布课程开课，前端传"cuid,roid,choice[],code,week"
     */
    public void teachSubmit(LessonVo lessonVo) {
        int[] choice = lessonVo.getChoice();
        int newMaxCcuid = teacherMapper.selectMaxCuid() + 1;
        int startTime = choice[0];
        for(int i = 0; i < choice.length; i++) {
            if (i == choice.length - 1) {
                lessonVo.setStarttime(startTime);
                lessonVo.setEndtime(choice[i]);
                lessonVo.setCcuid(newMaxCcuid);
                teacherMapper.insertClesson(lessonVo);
                teacherMapper.insertTeaching(lessonVo);
                break;
            }

            if (choice[i + 1] == choice[i] + 1) {
            } else {
                lessonVo.setStarttime(startTime);
                lessonVo.setEndtime(choice[i]);
                lessonVo.setCcuid(newMaxCcuid);
                teacherMapper.insertClesson(lessonVo);
                startTime = choice[i + 1];
            }
        }
    }

}
