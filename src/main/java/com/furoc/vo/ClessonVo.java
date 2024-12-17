package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName clesson
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClessonVo implements Serializable {
    /**
     * 开课id
     */
    private Integer ccuid;

    /**
     * 开课名字
     */
    private String cuname;

    /**
     * 教室id
     */
    private Integer roid;

    /**
     * 教室名
     */
    private String location;

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

    /**
     * 描述
     */
    private String description;

}