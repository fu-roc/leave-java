package com.furoc.controller;

import com.furoc.controller.utils.Result;
import com.furoc.service.ImageService;
import com.furoc.service.StuService;
import com.furoc.utils.StringUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Zoc
 * @Date: 2023/6/27 16:37
 * @Description: DataSubmissionController
 */
@RestController
public class ProofController {
    private final StuService stuService;
    private final ImageService imageService;

    public ProofController(ImageService imageService, StuService stuService) {
        this.imageService = imageService;
        this.stuService = stuService;
    }

    /*
    学生二课证明材料上传
     */
    @PostMapping("/stu/secondScore-proof")
    public Result secondScoreProof(@RequestParam("proof") MultipartFile prool) throws IOException {
        boolean notEmpty = !prool.isEmpty();
        String imgName = null;
        //有图片上传则删除老图片
        if (notEmpty) {
            // 获取文件的名称
            String fileName = prool.getOriginalFilename();
            // 使用工具类根据上传文件生成唯一图片名称
            if (fileName != null) {
                imgName = StringUtil.getRandomImgName(fileName, "secondScoreProof");
            }
        }
        //图片上传七牛云
        FileInputStream inputStream = (FileInputStream) prool.getInputStream();
        String path = imageService.uploadQNImg(inputStream, imgName);
        System.out.println("七牛云返回的图片链接: " + path);
        if (path != null) {
            return Result.success(path);
        } else return Result.error("上传失败");
    }

    /*
    学生免听免修证明材料上传
     */
    @PostMapping("/stu/free-proof")
    public Result freeProof(@RequestParam("proof") MultipartFile prool) throws IOException {
        boolean notEmpty = !prool.isEmpty();
        String imgName = null;
        if (notEmpty) {
            // 获取文件的名称
            String fileName = prool.getOriginalFilename();
            // 使用工具类根据上传文件生成唯一图片名称
            if (fileName != null) {
                imgName = StringUtil.getRandomImgName(fileName, "freeProof");
            }
        }
        //图片上传七牛云
        FileInputStream inputStream = (FileInputStream) prool.getInputStream();
        String path = imageService.uploadQNImg(inputStream, imgName);
        System.out.println("七牛云返回的图片链接: " + path);
        if (path != null) {
            return Result.success(path);
        } else return Result.error("上传失败");
    }

    @DeleteMapping("/stu/del-secondScore-proof")
    public Result deleteProof(@RequestParam("proof") String proof) {
        String s = proof.substring(proof.indexOf("/") + 1);
        boolean deleteQNImg = imageService.deleteQNImg(s);
        if (deleteQNImg) {
            return Result.success("删除成功");
        } else return Result.error("删除失败");
    }

    @DeleteMapping("/stu/del-free-proof")
    public Result deleteFreeProof(@RequestParam("proof") String proof) {
        String s = proof.substring(proof.indexOf("/") + 1);
        boolean deleteQNImg = imageService.deleteQNImg(s);
        if (deleteQNImg) {
            return Result.success("删除成功");
        } else return Result.error("删除失败");
    }
}
