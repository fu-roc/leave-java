package com.furoc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName teaching
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teaching implements Serializable {
    /**
     * 记录id
     */
    private Integer rid;

    /**
     * 开始节数
     */
    private Integer starttime;

    /**
     * 结束节数
     */
    private Integer endtime;

    /**
     * 教师id
     */
    private Integer tid;

    /**
     * 开课id
     */
    private Integer ccuid;

}