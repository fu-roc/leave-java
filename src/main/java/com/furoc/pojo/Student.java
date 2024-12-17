package com.furoc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName student
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable {
    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 学生姓名
     */
    private String uname;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 年级分院
     */
    private Integer gid;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 家庭住址
     */
    private String address;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 班级id
     */
    private Integer clid;

    /**
     * 学生头像
     */
    private String headPic;

}