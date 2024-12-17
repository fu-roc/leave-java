package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName lesson
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonVo implements Serializable {
    /**
     * 教师id
     */
    private Integer tid;

    /**
     * 课程id
     */
    private Integer cuid;

    /**
     * 课程名
     */
    private Integer ccuid;

    /**
     * 教室id
     */
    private Integer roid;

    /**
     * 开始节数
     */
    private Integer starttime;

    /**
     * 结束节数
     */
    private Integer endtime;


    /**
     * 选课数组
     */
    private int[] choice;

    /**
     * 二维码
     */
    private String code;

    /**
     * 星期几
     */
    private String week;

}