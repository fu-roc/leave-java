package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName room_application
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomApplicationVo implements Serializable {
    /**
     * 教室id
     */
    private Integer roid;

    /**
     * 教室id
     */
    private String location;

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

    /**
     * 教室申请的数组，例如choice[1,2,4,5,10,11,12]
     */
    private int[] choice;

}