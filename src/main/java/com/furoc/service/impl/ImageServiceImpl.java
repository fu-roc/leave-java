package com.furoc.service.impl;

import com.furoc.config.CloudStorageConfig;
import com.furoc.service.ImageService;
import com.google.gson.Gson;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Region;
import org.springframework.stereotype.Service;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

import java.io.FileInputStream;

/**
 * @Author: Zoc
 * @Date: 2023/6/25 9:48
 * @Description: UploadImageServiceImpl
 */
@Service
public class ImageServiceImpl implements ImageService {
    private final CloudStorageConfig config;
    // 七牛文件上传管理器
    private UploadManager uploadManager;
    private String token;

    private BucketManager bucketManager;

    public ImageServiceImpl(CloudStorageConfig config) {
        this.config = config;
        init();
    }

    private void init() {
        // 构造一个带指定Region对象的配置类, 注意这里的Region.regionCnEast2()需要根据存储区域选择
        uploadManager = new UploadManager(new Configuration(Region.regionCnEast2()));
        // 七牛认证管理
        Auth auth = Auth.create(config.getQiniuAccessKey(), config.getQiniuSecretKey());
        // 根据命名空间生成的上传token
        token = auth.uploadToken(config.getQiniuBucketName());
        // 七牛仓库
        bucketManager = new BucketManager(auth, new Configuration(Region.regionCnEast2()));
    }

    @Override
    public String uploadQNImg(FileInputStream file, String key) {
        try {
            // 上传图片文件
            Response res = uploadManager.put(file, key, token, null, null);
            if (!res.isOK()) {
                throw new RuntimeException("上传七牛出错：" + res);
            }
            // 解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
            // 这个returnPath是获得到的外链地址,通过这个地址可以直接打开图片
            return config.getQiniuDomain() + "/" + putRet.key;
        } catch (QiniuException e) {
            e.printStackTrace();
        }
        return "路径不存在";
    }

    @Override
    public boolean deleteQNImg(String fileName) {
        try {
            if (fileName != null) {
                bucketManager.delete(config.getQiniuBucketName(), fileName);
                return true;
            }
        } catch (QiniuException e) {
            //如果遇到异常，说明删除失败
            e.printStackTrace();
        }
        return false;
    }
}
