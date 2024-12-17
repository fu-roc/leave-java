package com.furoc.utils;



import cn.hutool.core.date.DateUtil;

import java.util.UUID;

/**
 * @Author: Zoc
 * @Date: 2023/6/25 9:44
 * @Description: StringUtil
 */
public class StringUtil {

    /**
     * @Description: 生成唯一图片名称
     * @Param: fileName
     * @return: 云服务器fileName
     */
    public static String getRandomImgName(String fileName, String path) {

        int index = fileName.lastIndexOf(".");

        if (fileName.isEmpty() || index == -1) {
            throw new IllegalArgumentException();
        }
        // 获取文件后缀
        String suffix = fileName.substring(index);
        // 生成UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        // 生成上传至云服务器的路径
        return path + "/" + DateUtil.today() + "-" + uuid + suffix;
    }
}
