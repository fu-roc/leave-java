package com.cyz.controller;

import com.cyz.controller.utils.Data;
import com.cyz.controller.utils.Result;
import com.cyz.service.UserService;
import com.cyz.utils.JwtUtils;
import com.cyz.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        boolean login = userService.login(user,id);
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

}
