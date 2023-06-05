package com.cyz.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 授课情况表
 * @TableName teaching
 */
@Data
public class Teaching implements Serializable {
    /**
     * 记录id
     */
    private Integer rid;

    /**
     * 教师id
     */
    private Integer tid;

    /**
     * 课程id
     */
    private Integer cuid;

    /**
     * 上课教室
     */
    private String room;

    /**
     * 上课时间
     */
    private String starttime;

    private static final long serialVersionUID = 1L;
}