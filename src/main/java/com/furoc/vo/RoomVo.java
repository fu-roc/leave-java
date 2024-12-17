package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName room
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomVo implements Serializable {
    /**
     * 教室id
     */
    private Integer roid;

    /**
     * 地点
     */
    private String location;

    /**
     * 开始节数
     */
    private Integer starttime;

    /**
     * 结束节数
     */
    private Integer endtime;

    /**
     * 使用日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date date;

    /**
     * 使用日期是星期几
     */
    private String week;

}