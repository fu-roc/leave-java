package com.furoc.controller;

import com.furoc.config.CloudStorageConfig;
import com.furoc.controller.utils.Result;
import com.furoc.service.ImageService;
import com.furoc.service.StuService;
import com.furoc.service.TeacherService;
import com.furoc.utils.JwtUtils;
import com.furoc.utils.StringUtil;
import com.sun.istack.internal.NotNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @Author: Zoc
 * @Date: 2023/6/26 18:20
 * @Description: HeadPicController
 */
@RestController
public class ProfilePicController {

    private final StuService stuService;
    private final TeacherService teacherService;
    private final ImageService imageService;
    String headPicUrl;

    public ProfilePicController(CloudStorageConfig config, ImageService imageService, StuService stuService, TeacherService teacherService) {
        headPicUrl = config.getQiniuDomain();
        this.imageService = imageService;
        this.stuService = stuService;
        this.teacherService = teacherService;
    }

    @GetMapping("/getHeadPic/{head}/{Pic}")
    public Result getHeadPic(@PathVariable("head") String head, @PathVariable("Pic") String Pic) {
        String headPic = head + "/" + Pic;
        return Result.success(headPicUrl + "/" + headPic);
    }

    /*
    更新老师头像
     */
    @PutMapping("/tea/updateHeadPic")
    public Result updateHeadPic(@RequestParam("headPic") MultipartFile headPic, HttpServletRequest req) throws IOException {
        String token = req.getHeader("token");
        Integer id = JwtUtils.parseJwt(token);
        boolean notEmpty = !headPic.isEmpty();
        //有图片上传则删除老图片
        if (notEmpty) {
            String oldPhoto = teacherService.findTeaById(id).getHeadPic();
            if (oldPhoto != null && !oldPhoto.equals("")) {
                imageService.deleteQNImg(oldPhoto);
            }
        }
        // 获取文件的名称
        String fileName = headPic.getOriginalFilename();
        // 使用工具类根据上传文件生成唯一图片名称
        String imgName = null;
        if (fileName != null) {
            imgName = StringUtil.getRandomImgName(fileName, "teacher");
        }
        //将图片路径存入数据库
        return getResult(headPic, imgName, teacherService.updateHeadPic(id, imgName));
    }

    /*
    更新学生头像
     */
    @PutMapping("/stu/updateHeadPic")
    public Result updateHeadPic2(@RequestParam("headPic") MultipartFile headPic, HttpServletRequest req) throws IOException {
        String token = req.getHeader("token");
        Integer id = JwtUtils.parseJwt(token);
        boolean notEmpty = !headPic.isEmpty();
        //有图片上传则删除老图片
        if (notEmpty) {
            String oldPhoto = stuService.getStuInfo(id).getHeadPic();
            if (oldPhoto != null && !oldPhoto.equals("")) {
                imageService.deleteQNImg(oldPhoto);
            }
        }
        // 获取文件的名称
        String fileName = headPic.getOriginalFilename();
        // 使用工具类根据上传文件生成唯一图片名称
        String imgName = null;
        if (fileName != null) {
            imgName = StringUtil.getRandomImgName(fileName, "student");
        }
        //将图片路径存入数据库
        return getResult(headPic, imgName, stuService.updateHeadPic(id, imgName));
    }

    @NotNull
    private Result getResult(@RequestParam("headPic") MultipartFile headPic, String imgName, int row) throws IOException {
        if (row != 0) {
            //图片上传七牛云
            FileInputStream inputStream = (FileInputStream) headPic.getInputStream();
            String path = imageService.uploadQNImg(inputStream, imgName);
            System.out.println("七牛云返回的图片链接: " + path);
            return Result.success("更新成功");
        } else return Result.error("更新失败");
    }
}
