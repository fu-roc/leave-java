package com.furoc.controller;

import com.furoc.controller.utils.Data;
import com.furoc.controller.utils.Result;
import com.furoc.service.UserService;
import com.furoc.utils.JwtUtils;
import com.furoc.vo.UpdateDTO;
import com.furoc.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*
    登录，0为学生，1为教师登录
     */
    @PostMapping("/{id}")
    public Result login(@RequestBody UserVo user, @PathVariable int id) {
        System.out.println(id);
        boolean login = userService.login(user, id);
        if (login) {
            //      创建令牌，添加信息
            Map<String, Object> claims = new HashMap<>();
            claims.put("uid", user.getUid());
            String jwt = JwtUtils.generateJwt(claims);
            Data data = new Data(jwt);
            return Result.success(data);
        } else
            return Result.error("验证失败");
    }


    @PutMapping("/update/info/{id}")
    public Result update(HttpServletRequest req, @RequestBody UpdateDTO updateDTO, @PathVariable Integer id) {
        String token = req.getHeader("token");
        Integer uid = JwtUtils.parseJwt(token);
        updateDTO.setUid(uid);
        int i = userService.updateUserInfo(updateDTO, id);
        if (i > 0) {
            return Result.success(null);
        } else {
            return Result.error("服务器错误");
        }

    }

}
