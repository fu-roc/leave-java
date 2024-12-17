package com.furoc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName room
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room implements Serializable {
    /**
     * 教室id
     */
    private Integer roid;

    /**
     * 地点
     */
    private String location;

    /**
     * 教室描述
     */
    private String description;

}