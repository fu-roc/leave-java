package com.cyz.vo;

import lombok.Data;

@Data
public class StuVo {
    /**
     * 姓名
     */
    private String uname;

    /**
     * 班级id
     */
    private String clname;

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
}
