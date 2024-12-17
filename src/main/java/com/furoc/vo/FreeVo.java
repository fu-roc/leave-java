package com.furoc.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: Zoc
 * @Date: 2023/6/27 15:06
 * @Description: FreeVo
 */
@Data
public class FreeVo implements Serializable {
    /**
     * 免听id
     */
    private Integer mid;

    /**
     * 证明材料
     */
    private String proof;

    /**
     * 申请理由
     */
    private String reason;

    /**
     * 课程名
     */
    private String cuname;

    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 学生姓名
     */
    private String uname;

    /**
     * 结果
     */
    private String result;

    /**
     * 区分免听免修,0为免听1为免修
     */
    private String distinct;
}
