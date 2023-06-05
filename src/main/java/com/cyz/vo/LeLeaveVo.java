package com.cyz.vo;

import lombok.Data;

@Data
public class LeLeaveVo {

    /**
     * 课程名
     */
    private String cuname;

    /**
     * 辅导员结果，“审核中”、“通过”、“不通过”
     */
    private String resultInst;

    /**
     * 教师结果，“审核中”、“通过”、“不通过”
     */
    private String resultTea;

    /**
     * 请假的日期
     */
    private String date;
}
