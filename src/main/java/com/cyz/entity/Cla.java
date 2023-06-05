package com.cyz.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 班级信息表
 * @TableName cla
 */
@Data
public class Cla implements Serializable {
    /**
     * 班级id
     */
    private Integer clid;

    /**
     * 班级名
     */
    private String clname;

    /**
     * 班级描述
     */
    private String description;

    /**
     * 班长sid
     */
    private Integer sid;

    /**
     * 辅导员id
     */
    private Integer tid;

    private static final long serialVersionUID = 1L;
}