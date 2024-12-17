package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceVo {
    /**
     * 出勤次数
     */
    private Integer attendance;

    /**
     * 缺勤次数
     */
    private Integer absence;

    /**
     * 课程id
     */
    private Integer cuid;

    /**
     * 课程名
     */
    private String cuname;
}
