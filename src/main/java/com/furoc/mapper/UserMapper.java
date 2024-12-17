package com.furoc.mapper;

import com.furoc.vo.UpdateDTO;
import com.furoc.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {

    /**
     * 学生登录
     */
    @Select("select sid,pwd from student where sid = #{uid} and pwd = #{pwd}")
    int loginStu(UserVo user);

    /**
     * 教师登录
     */
    @Select("select tid,pwd from teacher where tid = #{uid} and pwd = #{pwd}")
    int loginTea(UserVo user);

    /**
     * 学生修改
     */
    @Update("update student set uname = #{uname},email = #{email},address = #{address},phone = #{phone} where sid = #{uid}")
    int updateStu(UpdateDTO stu);


    /*
    教师修改
     */
    @Update("update teacher set tname = #{uname},phone = #{phone},email = #{email},address = #{address} where tid = #{uid}")
    int updateTea(UpdateDTO tea);
}
