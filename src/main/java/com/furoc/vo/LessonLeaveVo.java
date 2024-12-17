package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LessonLeaveVo {
    /**
     * 记录id
     */
    private Integer rid;

    /**
     * 请假日期
     */
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
     * 开课名称
     */
    private String cuname;

    /**
     * 学生姓名
     */
    private String uname;

    /**
     * 学生班级
     */
    private String clname;

}
