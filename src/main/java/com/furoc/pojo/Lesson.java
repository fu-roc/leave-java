package com.furoc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName lesson
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
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

}