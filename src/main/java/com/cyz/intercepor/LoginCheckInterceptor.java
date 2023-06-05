package com.cyz.intercepor;

import com.alibaba.fastjson.JSON;
import com.cyz.controller.utils.Result;
import com.cyz.utils.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
//        获取令牌
        String jwt = req.getHeader("token");
//        如果令牌为空
        if (!StringUtils.hasLength(jwt)) {
//            将对象转换成json字符串
            Result result = Result.error("NOT_USEFUL");
//            使用 UTF-8 编码格式生成 JSON 字符串
            String jsonString = JSON.toJSONString(result);
//            响应json字符串
            resp.getWriter().write(jsonString);
            return false;
        }
//        解析令牌
        try {
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) {
            Result result = Result.error("NOT_LOGIN");
            String jsonString = JSON.toJSONString(result);
//            响应json字符串
            resp.getWriter().write(jsonString);
            return false;
        }
//        令牌合法，放行
        return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
