package com.cyz.mapper;

import com.cyz.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

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
}
