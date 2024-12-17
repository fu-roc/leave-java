package com.furoc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName teacher
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher implements Serializable {
    /**
     * 教师id
     */
    private Integer tid;

    /**
     * 教师姓名
     */
    private String tname;

    /**
     * 教师称号
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
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 学年绩效评级
     */
    private String level;

    /**
     * 所属分院
     */
    private String college;

    /**
     * 教师头像
     */
    private String headPic;

}