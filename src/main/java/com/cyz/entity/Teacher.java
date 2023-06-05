package com.cyz.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 教师信息表
 * @TableName teacher
 */
@Data
public class Teacher implements Serializable {
    /**
     * 教师id
     */
    private Integer tid;

    /**
     * 姓名
     */
    private String tname;

    /**
     * 教师头衔
     */
    private String title;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 办公室
     */
    private String cla;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 地址
     */
    private String address;

    /**
     * 评级
     */
    private String yearLevel;

    /**
     * 所在分院
     */
    private String college;

    private static final long serialVersionUID = 1L;
}