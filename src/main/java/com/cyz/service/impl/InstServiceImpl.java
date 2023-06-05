package com.cyz.service.impl;

import com.cyz.mapper.InstMapper;
import com.cyz.service.InstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstServiceImpl implements InstService {
//    @Autowired
//    private InstMapper instMapper;
//
//    /**
//     * 查询辅导员的collegeId
//     */
//    public int queryCollegeId(String uid) {
//        return instMapper.queryCollegeId(uid);
//    }
//
//    /**
//     * 辅导员查询所有请假审核中记录
//     */
//    public List<HistoryInfo> queryleave(StuBaseInfos stuBaseInfos) {
//        return instMapper.queryleave(stuBaseInfos);
//    }
//
//    /**
//     * 辅导员审核请假的记录
//     */
//    public void examine(HistoryInfo historyInfo) {
//        instMapper.examine(historyInfo);
//    }
//
//    /**
//     * 辅导员查询历史记录
//     */
//    public List<HistoryInfo> queryhistory(HistoryInfo historyInfo) {
//        return instMapper.queryhistory(historyInfo);
//    }
//
//    /**
//     * 辅导员查询所有出校审核中记录
//     */
//    public List<CampusHistory> querycampus(StuBaseInfos stuBaseInfos) {
//        return instMapper.querycampus(stuBaseInfos);
//    }
//
//    /**
//     * 辅导员审核出校的记录
//     */
//    public void examinecampus(CampusHistory campusHistory) {
//        instMapper.examinecampus(campusHistory);
//    }
//
//    /**
//     * 辅导员查询请假历史记录
//     */
//    public List<CampusHistory> querycampushistory(CampusHistory campusHistory) {
//        return instMapper.querycampushistory(campusHistory);
//    }
//
//    /**
//     * 获取辅导员名字
//     */
//    public StuBaseInfos info(String uid) {
//        return instMapper.info(uid);
//    }

}
