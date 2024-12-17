package com.furoc.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName room_application
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomApplication implements Serializable {
    /**
     * 教室id
     */
    private Integer roid;

    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 开始节数
     */
    private Integer starttime;

    /**
     * 结束节数
     */
    private Integer endtime;

    /**
     * 申请时间
     */
    private Date date;

    /**
     * 教室哪一天使用
     */
    private Date apply;

}