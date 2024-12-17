package com.furoc.pojo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 
 * @TableName time_info
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TimeInfo implements Serializable {
    /**
     * 课程节数
     */
    private Integer num;

    /**
     * 开始时间
     */
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Date starttime;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "hh:mm:ss")
    private Date endtime;

}