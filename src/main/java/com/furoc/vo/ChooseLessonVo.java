package com.furoc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 
 * @TableName choose_lesson
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChooseLessonVo implements Serializable {

    /**
     * 成绩
     */
    private Integer grade;

    /**
     * 开课id
     */
    private Integer ccuid;


    /**
     * 课程名
     */
    private String cuname;

}