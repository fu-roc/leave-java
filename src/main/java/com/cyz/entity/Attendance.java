package com.cyz.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 学生出勤表
 * @TableName attendance
 */
@Data
public class Attendance implements Serializable {
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
     * 点名时间
     */
    private String time;

    /**
     * 是否点上，1为是、0为否
     */
    private Integer attend;

    private static final long serialVersionUID = 1L;
}