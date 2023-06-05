package com.cyz.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 学生选课表
 * @TableName stu_lesson
 */
@Data
public class StuLesson implements Serializable {
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

    private static final long serialVersionUID = 1L;
}