package com.cyz.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 课程请假表
 * @TableName le_leave
 */
@Data
public class LeLeave implements Serializable {
    /**
     * 记录id
     */
    private Integer rid;

    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 课程id
     */
    private Integer cuid;

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

    private static final long serialVersionUID = 1L;
}