package com.furoc.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName free
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Free implements Serializable {
    /**
     * 免听id
     */
    private Integer mid;

    /**
     * 证明材料
     */
    private String proof;

    /**
     * 申请理由
     */
    private String reason;

    /**
     * 开课id
     */
    private Integer ccuid;

    /**
     * 学生id
     */
    private Integer sid;

    /**
     * 结果
     */
    private String result;

    /**
     * 区分免听免修,0为免听1为免修
     */
    private String distinct;

}