package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName second_score
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SecondScoreVo implements Serializable {
    /**
     * 记录id
     */
    private Integer rid;

    /**
     * 类别
     */
    private String type;

    /**
     * 活动名称
     */
    private String name;

    /**
     * 奖项名称
     */
    private String reward;

    /**
     * 获奖时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    /**
     * 获奖等级
     */
    private String level;

    /**
     * 证明材料
     */
    private String proof;

    /**
     * 分值
     */
    private Double grade;

    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 学生名
     */
    private String uname;

    /**
     * 教师名称
     */
    private String tname;

    /**
     * 结果
     */
    private String result;

}