package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @version 1.0
 * @Author Wsh
 * @Date 2023/6/27 16:55
 * @describe
 * @xinxi 2020410103 wsh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateDTO {
    private Integer uid;
    private String uname;
    private String phone;
    private String address;
    private String email;

}
