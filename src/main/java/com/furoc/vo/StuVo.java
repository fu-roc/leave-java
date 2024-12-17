package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StuVo {

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
     * 班级名
     */
    private String clname;

    /**
     * 学生头像
     */
    private String headPic;
}
