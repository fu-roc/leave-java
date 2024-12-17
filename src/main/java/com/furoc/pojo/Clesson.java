package com.furoc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName clesson
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Clesson implements Serializable {
    /**
     * 开课id
     */
    private Integer ccuid;

    /**
     * 课程id
     */
    private Integer cuid;

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
     * 二维码
     */
    private String code;

    /**
     * 星期几
     */
    private String week;

}