package com.example.personnel_management_system.filter;



import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.service.UserService;
import com.example.personnel_management_system.util.JwtUtil;
import com.example.personnel_management_system.util.RequestUtil;
import com.example.personnel_management_system.util.ResultUtil;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;


/**
 * @ClassName Filters
 * @Description 前端过滤器
 * @Author ZheKai Liang
 * @Since 2022/6/30 17:09
 **/
@Slf4j
@WebFilter(urlPatterns = "/**") //url路径为  /**(所有路径)  时，触发过滤器
@Component
@Order(100)
public class UserFilter implements Filter {

    private final JwtUtil jwtUtil;
    private final UserService userService;

    public UserFilter(JwtUtil jwtUtil, UserService userService) {
        this.jwtUtil = jwtUtil;
        this.userService = userService;
    }

//    private final List<String> url = Arrays.asList("");        // 需要拦截的路径

    /**
     * 过滤需要用户登录的操作
     *
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        if (url.contains(RequestUtil.getUrl())) {
//            try {
//                    jwtUtil.parseJwt(RequestUtil.getHeader("jwt"));
//                    filterChain.doFilter(servletRequest, servletResponse);
//            } catch (ExpiredJwtException e) {
//                ResultUtil.sendResponse((HttpServletResponse) servletResponse, ResultUtil.error(ResultEnum.THE_TOKEN_EXPIRES));
//            } catch (JwtException e) {
//                ResultUtil.sendResponse((HttpServletResponse) servletResponse, ResultUtil.error(ResultEnum.THE_TOKEN_IS_NOT_LEGITIMATE));
//            } catch (Exception e) {
//                ResultUtil.sendResponse((HttpServletResponse) servletResponse, ResultUtil.error(ResultEnum.UNKNOWN_ERROR));
//            }
//        } else if (RequestUtil.getUrl().equals("/user/register")||RequestUtil.getUrl().equals("/user/login")){
            filterChain.doFilter(servletRequest, servletResponse);        //直接放行
//        }
    }
}
