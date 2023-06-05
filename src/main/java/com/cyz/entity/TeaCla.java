package com.cyz.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 教师辅导班级表
 * @TableName tea_cla
 */
@Data
public class TeaCla implements Serializable {
    /**
     * 记录id
     */
    private Integer rid;

    /**
     * 教师id
     */
    private Integer tid;

    /**
     * 班级id
     */
    private Integer clid;

    private static final long serialVersionUID = 1L;
}