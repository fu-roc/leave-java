package com.cyz.mapper;

import com.cyz.entity.*;
import com.cyz.vo.AttendanceVo;
import com.cyz.vo.LeLeaveVo;
import com.cyz.vo.LeaveInfoVo;
import com.cyz.vo.StuVo;
import org.apache.ibatis.annotations.*;

import javax.xml.ws.WebServiceClient;
import java.util.List;

@Mapper
public interface StuMapper {

    /*
    获取自己基础信息
     */
    @Select("select uname,gender,age,phone,email,address,clname from cla c join (select uname,gender,age,phone,email,address,clid from student where sid = #{uid}) s on c.clid = s.clid")
    public StuVo getStuInfo(Integer uid);


    /*
    获取历史请假信息
     */
    @Select("select date,starttime,endtime,destination,reason,result,tname,remarks from teacher t join (select date,starttime,endtime,destination,reason,result,remarks,tid from leave_info where sid = #{uid} and result != '审核中') trecode on t.tid = trecode.tid")
    public List<LeaveInfoVo> getLeaveHistory(Integer uid);


    /*
    获取审核中请假信息
     */
    @Select("select date,starttime,endtime,destination,reason,result,tname,remarks from teacher t join (select date,starttime,endtime,destination,reason,result,remarks,tid from leave_info where sid = #{uid} and result = '审核中') trecode on t.tid = trecode.tid")
    public List<LeaveInfoVo> getLeaveWorking(Integer uid);


    /*
    获取课程历史请假信息
     */
    @Select("select cuname,result_inst resultInst,result_tea resultTea,date from lesson le join (select cuid,result_inst,result_tea,date from le_leave where sid = #{uid}) ll on le.cuid = ll.cuid where result_inst != '审核中' and result_tea != '审核中'")
    public List<LeLeaveVo> getCourseHistory(Integer uid);


    /*
    获取课程审核中请假信息
     */
    @Select("select cuname,result_inst resultInst,result_tea resultTea,date from lesson le join (select cuid,result_inst,result_tea,date from le_leave where sid = #{uid}) ll on le.cuid = ll.cuid where result_inst = '审核中' or result_tea = '审核中'")
    public List<LeLeaveVo> getCourseWorking(Integer uid);


    /*
    出勤记录查看
     */
    @Select("select cuname,attendance,absence,le.cuid from lesson le join (select count(attend)-sum(attend) absence,sum(attend) attendance,cuid from attendance where sid = #{uid} group by cuid) cc on le.cuid = cc.cuid")
    public List<AttendanceVo> getAllAttendance(Integer uid);


    /*
    点名详细记录查看
     */
    @Select("select time,attend from attendance where sid = #{uid} and cuid = #{cuid}")
    public List<Attendance> getDetailAttendance(Integer uid, Integer cuid);

    /*
    查询对应的辅导员
     */
    @Select("select t.tid,tname from teacher t join (select tid from student s join cla c on s.clid = c.clid where s.sid = #{uid}) tt on t.tid = tt.tid")
    public Teacher getInstId(Integer uid);

    /*
    离校请假申请
     */
    @Insert("insert into leave_info value (null,#{sid},now(),#{starttime},#{endtime},#{destination},#{reason},'审核中',#{tid},null)")
    public int leaveApply(LeaveInfo leaveInfo);

    /*
    查询该学生所有课程
     */
    @Select("select cuname,le.cuid from lesson le join (select cuid from stu_lesson where sid = #{uid}) ll on le.cuid = ll.cuid")
    public List<Lesson> getAllCourse(Integer uid);

    /*
    课程请假申请
     */
    @Insert("insert into le_leave value (null,#{sid},#{cuid},'审核中','审核中',#{date})")
    public int courseApply(LeLeave leLeave);
}
