package com.furoc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName cls
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cls implements Serializable {
    /**
     * 班级id
     */
    private Integer clid;

    /**
     * 班级名
     */
    private String clname;

    /**
     * 课程描述
     */
    private String description;

    /**
     * 班长id
     */
    private Integer sid;

    /**
     * 教师id
     */
    private Integer tid;

}