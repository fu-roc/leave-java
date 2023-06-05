package com.cyz.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface InstMapper {
//    /**
//     *查询辅导员的collegeId
//     */
//    @Select("select l.collegeId from login l where uid = #{uid}")
//    int queryCollegeId(String uid);
//
//    /**
//     *辅导员查询所有请假审核中记录
//     *
//     */
//    List<HistoryInfo> queryleave(StuBaseInfos stuBaseInfos);
//
//    /**
//     *辅导员审核请假的记录
//     *
//     */
//    @Update("update leavehistory set result = #{result} where id = #{id}")
//    @ResultMap("historyInfoResultMap")
//    void examine(HistoryInfo historyInfo);
//
//    /**
//     * 辅导员查询请假历史记录
//     *
//     */
//    List<HistoryInfo> queryhistory(HistoryInfo historyInfo);
//
//    /**
//     *辅导员查询所有出校审核中记录
//     *
//     */
//    List<CampusHistory> querycampus(StuBaseInfos stuBaseInfos);
//
//    /**
//     *辅导员审核出校的记录
//     *
//     */
//    @Update("update campushistory set result = #{result} where id = #{id}")
//    @ResultMap("campusHistoryResultMap")
//    void examinecampus(CampusHistory campusHistory);
//
//    /**
//     * 辅导员查询出校历史记录
//     *
//     */
//    List<CampusHistory> querycampushistory(CampusHistory campusHistory);
//
//    /**
//     *获取辅导员名字
//     *
//     */
//    @Select("select l.uname from login l where uid = #{uid}")
//    StuBaseInfos info(String uid);
}
