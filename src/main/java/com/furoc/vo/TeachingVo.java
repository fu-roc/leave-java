package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName teachingVo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeachingVo implements Serializable {
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
     * 开课姓名
     */
    private String cuname;

    /**
     * 开课id
     */
    private Integer ccuid;

    /*
     * 地点
     */
    private String location;

    /*
     * 星期几
     */
    private String week;

    /*
     * 课程描述
     */
    private String description;

}