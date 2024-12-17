package com.furoc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName choose_lesson
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChooseLesson implements Serializable {
    /**
     * 记录id
     */
    private Integer rid;

    /**
     * 成绩
     */
    private Integer grade;

    /**
     * 开课id
     */
    private Integer ccuid;

    /**
     * 学生id
     */
    private Integer sid;

}