package com.cyz.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * 学生信息表
 * @TableName student
 */
@Data
public class Student implements Serializable {
    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 姓名
     */
    private String uname;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 班级id
     */
    private Integer clid;

    /**
     * 性别
     */
    private String gender;

    /**
     * 年龄
     */
    private Integer age;

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

    private static final long serialVersionUID = 1L;
}