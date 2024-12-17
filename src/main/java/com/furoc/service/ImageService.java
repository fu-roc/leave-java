package com.furoc.service;

import java.io.FileInputStream;

/**
 * @Author: Zoc
 * @Date: 2023/6/25 9:47
 * @Description: UploadImageService
 */
public interface ImageService {

    String uploadQNImg(FileInputStream file, String path);

    boolean deleteQNImg(String fileName);
}
