package com.furoc.mapper;

import com.furoc.pojo.Clesson;
import com.furoc.pojo.Lesson;
import com.furoc.pojo.Teacher;
import com.furoc.vo.LessonLeaveVo;
import com.furoc.vo.LessonVo;
import com.furoc.vo.TeachingVo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 13926
 * @description 针对表【teacher(教师信息表)】的数据库操作Mapper
 * @createDate 2023-06-09 11:12:59
 * @Entity com.leave.entity.Teacher
 */
@Mapper
public interface TeacherMapper {
    /**
     * 老师查询课程请假记录
     * 根据课程id，开始请假时间，学生sid和学生姓名查出请假信息列表
     */
    List<LessonLeaveVo> selectLeaveHistory(Integer tid);

    List<LessonLeaveVo> selectLeaveWorking(Integer tid);

    //所有请假记录
    List<LessonLeaveVo> selectAllLeaveInfo();

    Teacher selectByTid(Integer tid);

    Boolean selectIsTea(Integer tid);

    int updateResultByRid(@Param("rid") Integer rid, @Param("resultTea") String resultTea);

    Teacher selectTeaByTid(Integer tid);

    int updateInfo(Teacher tea);

    int updateHeadPic(Integer tid, String imgName);

    /*
    查看自己教授的课程
     */
    @Select("select ccuid,cuname,location,starttime,endtime,week,lll.description from room r join (select roid,starttime,endtime,code,week,cuname,ll.ccuid,description from lesson le " +
            "join (select rid,roid,starttime,endtime,code,week,tid,teaching.ccuid,cuid from teaching " +
            "join (select roid,starttime,endtime,code,week,ccuid,cuid from clesson) cle on teaching.ccuid = cle.ccuid where tid = #{uid}) ll on le.cuid = ll.cuid) lll on lll.roid = r.roid")
    public ArrayList<TeachingVo> teachCourse(Integer uid);

    /*
    教师选择星期几上课，前端传"教室id、星期几"
     */
    @Select("select starttime,endtime from clesson where roid = #{roid} and week = #{week}")
    public ArrayList<Clesson> freeSection(Integer roid, String week);

    /*
    查询clesson开课数据库中当前在最大的ccuid，方便插入课程时使用
     */
    @Select("select max(ccuid) from clesson")
    public int selectMaxCuid();

    /*
    获取可以开课的课程列表
     */
    @Select("select cuid,cuname,description from lesson")
    public ArrayList<Lesson> teachList();

    /*
    老师申请课程，插入表teaching，一一对应
     */
    @Insert("insert into teaching(rid,tid,ccuid) value (null,#{tid},#{ccuid})")
    public void insertTeaching(LessonVo lessonVo);

    /*
    发布课程开课，前端传"cuid,roid,choice[],code,week"
     */
    public void insertClesson(LessonVo lessonVo);

}
