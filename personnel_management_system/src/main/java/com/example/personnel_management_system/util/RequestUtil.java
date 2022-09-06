package com.example.personnel_management_system.util;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName Utils
 * @Description 全局获取 request
 * @Author liangzk
 * @Since 2022/7/5 10:40
 **/
public class RequestUtil {

    /**
     * 获取HttpServletRequest
     * @return
     */
    public static HttpServletRequest getHttpServletRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 获取请求路径
     * @return
     */
    public static String getUrl()
    {
        return getHttpServletRequest().getRequestURI();
    }

    /**
     * 获取头信息
     * @param jwt
     * @return
     */
    public static String getHeader(String jwt)
    {
        return getHttpServletRequest().getHeader(jwt);
    }

}
