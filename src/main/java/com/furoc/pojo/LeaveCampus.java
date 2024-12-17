package com.furoc.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName leave_campus
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveCampus implements Serializable {
    /**
     * 请假id
     */
    private Integer lid;

    /**
     * 请假时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 离校时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date starttime;

    /**
     * 回校时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endtime;

    /**
     * 申请原因
     */
    private String reason;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 结果
     */
    private String result;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 教师id
     */
    private Integer tid;

    /**
     * 学生id
     */
    private Integer sid;

}