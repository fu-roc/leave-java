package com.furoc.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName lesson_leave
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonLeave implements Serializable {
    /**
     * 记录id
     */
    private Integer rid;

    /**
     * 请假日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 教师结果
     */
    private String resultTea;

    /**
     * 辅导员结果
     */
    private String resultInst;

    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 开课id
     */
    private Integer ccuid;

    /**
     * 课程第几周
     */
    private String nweek;
}