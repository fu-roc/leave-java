package com.furoc.mapper;

import com.furoc.pojo.*;
import com.furoc.vo.*;
import org.apache.ibatis.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface StuMapper {

    /*
    获取自己基础信息
     */
    @Select("select uname,gender,age,phone,email,address,clname,head_pic from cls c join (select uname,gender,age,phone,email,address,clid,head_pic from student where sid = #{uid}) s on c.clid = s.clid")
    public StuVo getStuInfo(Integer uid);

    /*
    获取历史离校请假信息
     */
    @Select("select date,starttime,endtime,destination,reason,result,tname,remarks from teacher t join (select date,starttime,endtime,destination,reason,result,remarks,tid from leave_campus where sid = #{uid} and result != '待审核') trecode on t.tid = trecode.tid")
    public List<LeaveCampusVo> getLeaveHistory(Integer uid);

    /*
    获取审核中离校请假信息
     */
    @Select("select date,starttime,endtime,destination,reason,result,tname,remarks from teacher t join (select date,starttime,endtime,destination,reason,result,remarks,tid from leave_campus where sid = #{uid} and result = '待审核') trecode on t.tid = trecode.tid")
    public List<LeaveCampusVo> getLeaveWorking(Integer uid);

    /*
    获取课程历史请假信息
     */
    @Select("select cuname,result_inst resultInst,result_tea resultTea,date from lesson le join (select ccuid,result_inst,result_tea,date from lesson_leave where sid = #{uid}) ll on le.cuid = ll.ccuid where result_inst != '待审核' and result_tea != '待审核'")
    public List<LessonLeaveVo> getCourseHistory(Integer uid);

    /*
    获取课程审核中请假信息
     */
    @Select("select cuname,result_inst resultInst,result_tea resultTea,date from lesson le join (select ccuid,result_inst,result_tea,date from lesson_leave where sid = #{uid}) ll on le.cuid = ll.ccuid where result_inst = '待审核' and result_tea = '待审核'")
    public List<LessonLeaveVo> getCourseWorking(Integer uid);

    /*
    出勤记录查看
     */
    @Select("select cuname,attendance,absence,le.cuid from lesson le join (select count(attend)-sum(attend) absence,sum(attend) attendance,ccuid from attendance where sid = #{uid} group by ccuid) cc on le.cuid = cc.ccuid")
    public List<AttendanceVo> getAllAttendance(Integer uid);

    /*
    点名详细记录查看
     */
    @Select("select time,attend from attendance where sid = #{uid} and ccuid = #{cuid}")
    public List<Attendance> getDetailAttendance(Integer uid, Integer cuid);

    /*
    查询对应的辅导员
     */
    @Select("select t.tid,tname from teacher t join (select tid from student s join cls c on s.clid = c.clid where s.sid = #{uid}) tt on t.tid = tt.tid")
    public Teacher getInstId(Integer uid);

    /*
    离校请假申请
     */
    @Insert("insert into leave_campus(lid,starttime,endtime,date,destination,reason,result,remarks,sid,tid) " +
            "value (null,#{starttime},#{endtime},now(),#{destination},#{reason},'待审核',null,#{sid},#{tid})")
    public int leaveApply(LeaveCampus leaveInfo);

    /*
    查询该学生所有课程
     */
    @Select("select llll.cuid,llll.ccuid,location,cuname,starttime,endtime,week,llll.description from room r join (select le.cuid,lll.ccuid,roid,cuname,starttime,endtime,week,description from lesson le join (select cuid,cl.ccuid,roid,starttime,endtime,week from clesson cl join (select ccuid from choose_lesson where sid = #{uid}) c_l on c_l.ccuid = cl.ccuid) lll on lll.cuid = le.cuid) llll on llll.roid = r.roid")
    public List<ClessonVo> getAllCourse(Integer uid);

    /*
    课程请假申请
     */
    @Insert("insert into lesson_leave(rid,date,result_tea,result_inst,sid,ccuid,nweek) value (null,now(),'待审核','待审核',#{sid},#{ccuid},#{nweek})")
    public int courseApply(LessonLeave lessonLeave);

    /*
    学生查看二课的申请历史情况
     */
    @Select("select rid,type,name,reward,time,ss.level,proof,grade,tname,result from teacher t " +
            "right join (select * from second_score where sid = #{uid}) ss " +
            "on ss.tid = t.tid where result = '已通过'")
    public ArrayList<SecondScoreVo> getHistoryProcess(Integer uid);

    /*
    学生查看二课的申请审核中情况
     */
    @Select("select rid,type,name,reward,time,ss.level,proof,grade,tname,result from teacher t " +
            "right join (select * from second_score where sid = #{uid}) ss " +
            "on ss.tid = t.tid where result = '待审核'")
    public ArrayList<SecondScoreVo> getApplyProcess(Integer uid);

    /*
    获取所有教室信息
     */
    @Select("select roid,location,description from room")
    public ArrayList<Room> getAllRoomInfo();

    /*
    获取某个id教室的是否空闲信息
     */
    @Select("select location,rct.starttime,rct.endtime from room r " +
            "join (select roid,starttime,endtime from room_application where apply = #{date} " +
            "union select roid,starttime,endtime from clesson where week = #{week}) rct " +
            "on rct.roid = r.roid where r.roid = #{roid}")
    public ArrayList<RoomVo> getFreeRoomInfo(RoomVo roomVo);

    /*
    获取时间表
     */
    @Select("select num,starttime,endtime from time_info")
    public ArrayList<TimeInfo> getTimeTable();

    /*
    教室申请，前端传roid,starttime,endtime,apply
     */
    @Insert("insert into room_application (roid,sid,starttime,endtime,date,apply) values (#{roid},#{sid},#{starttime},#{endtime},now(),#{apply})")
    public int saveClassApply(RoomApplicationVo roomApplication);

    /*
    获取所有开课记录
     */
    @Select("select ccuid,cuname,location,starttime,endtime,week,llc.description from room r right join (select ccuid,cuname,roid,starttime,endtime,week,description from lesson l join (select ccuid,cuid,roid,starttime,endtime,code,week from clesson where ccuid not in (select ccuid from choose_lesson where sid = #{uid})) ll on l.cuid = ll.cuid) llc on llc.roid = r.roid")
    public ArrayList<ClessonVo> getAllClasses(Integer uid);

    /*
    查看申请的教室
     */
    @Select("select r.roid,location,starttime,endtime,date,apply from room r right join(select roid,starttime,endtime,date,apply from room_application where sid = #{uid}) ro on r.roid = ro.roid order by apply asc")
    public ArrayList<RoomApplicationVo> getAllRoom(Integer uid);

    /*
    学生选课，前端传ccuid
     */
    @Insert("insert into choose_lesson(rid,grade,ccuid,sid) value (null,null,#{ccuid},#{uid})")
    public int saveClassById(Integer ccuid, Integer uid);

    /*
    学生选课退选
     */
    @Delete("delete from choose_lesson where ccuid = #{ccuid}")
    public void removeClassById(Integer ccuid);


    @Update("update student set head_pic = #{imgName} where sid = #{id}")
    int updateHeadPic(Integer id, String imgName);

    @Select("select proof from second_score join student s on s.sid = second_score.sid where s.sid = #{id}")
    String getSecondScoreProof(Integer id);

    @Update("update second_score set proof = #{imgName} where sid = #{id}")
    boolean updateProol(String imgName, Integer id);

    @Select("select proof from free where sid = #{id}")
    String getFreeProof(Integer id);

    @Update("update free set proof = #{imgName} where sid = #{id}")
    boolean updateFreeProol(String imgName, Integer id);

    /*
    学生二课成绩申请
     */
    @Insert("insert into second_score(rid,type,name,reward,time,level,proof,grade,sid,tid,result) value (null,#{type},#{name},#{reward},#{time},#{level},#{proof},#{grade},#{sid},#{tid},'待审核')")
    int secondScoreApply(SecondScore secondScore);

    /*
    学生免听免修申请
     */
    @Insert("insert into free(mid,proof,reason,ccuid,sid,result,`distinct`) value (null,#{proof},#{reason},#{ccuid},#{sid},'待审核',#{distinct})")
    int freeApply(Free free);

    /*
    获取免听免修申请历史记录为获取历史
     */
    @Select("select proof,reason,cuname,result,`distinct` from lesson l join (select * from free where sid = #{uid}) f on l.cuid = f.ccuid where result = '已通过'")
    public ArrayList<FreeVo> getFreeHistory(Integer uid);

    /*
    获取免听免修申请历史记录为获取待审核
     */
    @Select("select proof,reason,cuname,result,`distinct` from lesson l join (select * from free where sid = #{uid}) f on l.cuid = f.ccuid where result = '待审核'")
    public ArrayList<FreeVo> getFreeWorking(Integer uid);

}
