package com.cyz.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 课程信息表
 * @TableName lesson
 */
@Data
public class Lesson implements Serializable {
    /**
     * 课程id
     */
    private Integer cuid;

    /**
     * 课程名
     */
    private String cuname;

    /**
     * 课程描述
     */
    private String description;

    private static final long serialVersionUID = 1L;
}