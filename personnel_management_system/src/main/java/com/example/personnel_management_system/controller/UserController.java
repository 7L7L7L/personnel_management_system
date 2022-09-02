package com.example.personnel_management_system.controller;

import com.example.personnel_management_system.pojo.po.User;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.UserService;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName UserController
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/2 13:25
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public ResultVo<Object> login(User user){
        return userService.login(user);
    }
    @PostMapping("/register")
    public ResultVo<Object> register(User user){
        return userService.register(user);
    }
    @PostMapping("/updatePassword")
    public ResultVo<Object> updatePassword(User user){
        return userService.updatePassword(user);
    }
}
