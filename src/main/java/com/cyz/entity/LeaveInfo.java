package com.cyz.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 离校申请表
 * @TableName leave_info
 */
@Data
public class LeaveInfo implements Serializable {
    /**
     * 请假id
     */
    private Integer lid;

    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 申请时间
     */
    private String date;

    /**
     * 请假开始时间
     */
    private String starttime;

    /**
     * 请假结束时间
     */
    private String endtime;

    /**
     * 请假原因
     */
    private String reason;

    /**
     * 目的地
     */
    private String destination;

    /**
     * 申请结果
     */
    private String result;

    /**
     * 辅导员id
     */
    private Integer tid;

    /**
     * 备注
     */
    private String remarks;

    private static final long serialVersionUID = 1L;
}