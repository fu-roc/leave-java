package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class LeaveCampusVo {
    /**
     * 请假id
     */
    private Integer lid;

    /**
     * 教师名字
     */
    private String tname;

    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 学生姓名
     */
    private String uname;
    /**
     * 请假时间
     */
    private Date date;

    /**
     * 离校时间
     */
    private Date starttime;

    /**
     * 回校时间
     */
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

}
