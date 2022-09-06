package com.example.personnel_management_system.util;

import io.jsonwebtoken.*;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: JwtUtil
 * @Date: 2022/6/24
 * @Author: lvxy
 * jwt生成和校验工具类
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "jwt")
@Slf4j

/**
 * @ClassName Utiles
 * @Description jwt令牌生成解析器
 * @Author ZheKai Liang
 * @Since 2022/6/30 17:09
 **/
public class JwtUtil {

    /**
     * 密钥
     */
    private String secret;

    /**
     * 过期时间
     */
    private Long expiration;

    /**
     * 头部信息
     */
    private String header;

    /**
     * 生成jwt
     *
     * @return jwt串
     */
    public String generateJwt(Long id,String username) {
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username", username);
        JwtBuilder builder = Jwts.builder()
                .setClaims(map)                      //需要放在第一个，不然这个会覆盖之前所有的设置
                .setHeaderParam("byt", header)
                .signWith(SignatureAlgorithm.HS256, secret)
                .setExpiration(new Date(System.currentTimeMillis() + expiration));
        return builder.compact();
    }

    /**
     * 解析jwt
     * @param jwt
     * @return
     */
    public Map<String,Object> parseJwt(String jwt) {
        Map<String,Object> map;
        map = (Map<String,Object>)Jwts.parser().setSigningKey(secret).parse(jwt).getBody();
        return map;
    }
}
