package com.furoc.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Zoc
 * @Date: 2023/6/25 9:42
 * @Description: 云存储配置类
 */

@Data
@Configuration
public class CloudStorageConfig {

    /**
     * 七牛域名domain
     */
    @Value("${oss.qiniu.domain}")
    private String qiniuDomain;
    /**
     * 七牛ACCESS_KEY
     */
    @Value("${oss.qiniu.accessKey}")
    private String qiniuAccessKey;
    /**
     * 七牛SECRET_KEY
     */
    @Value("${oss.qiniu.secretKey}")
    private String qiniuSecretKey;
    /**
     * 七牛空间名
     */
    @Value("${oss.qiniu.bucketName}")
    private String qiniuBucketName;

}
