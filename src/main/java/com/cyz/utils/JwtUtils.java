package com.cyz.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    //    设置密钥
    private static String signKey = "P7BF3KHS6M1EX8VD3JF0I&G5SF3#HS&";
    //    过期时间30分钟
    private static Long expire = 2592000000L;

    /*
    生成JWT令牌，第二部分负载payload中存储数据
     */
    public static String generateJwt(Map<String, Object> data) {
        String jwt = Jwts.builder()
                .addClaims(data)    //设置内容
                .signWith(SignatureAlgorithm.HS256, signKey)    //设置签名算法和密钥
                .setExpiration(new Date(System.currentTimeMillis() + expire))   //设置过期时间
                .compact();
        return jwt;
    }

    /*
    解析JWT令牌，
     */
    public static Integer parseJwt(String jwt) {
        Claims data = Jwts.parser()
                .setSigningKey(signKey)     //设置密钥
                .parseClaimsJws(jwt)    //添加令牌字符串
                .getBody();     //获取数据
        Integer uid = data.get("uid", Integer.class);
        return uid;
    }
}
