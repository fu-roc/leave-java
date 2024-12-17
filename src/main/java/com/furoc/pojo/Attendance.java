package com.furoc.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName attendance
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance implements Serializable {
    /**
     * 记录id
     */
    private Integer rid;

    /**
     * 时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /**
     * 是否出勤
     */
    private Integer attend;

    /**
     * 开课id
     */
    private Integer ccuid;

    /**
     * 学生id
     */
    private Integer sid;

}