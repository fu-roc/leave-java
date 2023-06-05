package com.cyz.vo;

import lombok.Data;

import java.util.Date;

@Data
public class LeaveInfoVo {
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
     * 辅导员名
     */
    private String tname;

    /**
     * 备注
     */
    private String remarks;
}
