package com.example.personnel_management_system.controller;

import com.example.personnel_management_system.pojo.po.User;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.UserService;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/userBind/{id}/{uuid}")
    public ResultVo<Object> userBind(@PathVariable Long id,@PathVariable Long uuid){
        return userService.userBind(id,uuid);
    }
    @GetMapping("/getOneById/{id}")
    public ResultVo<Object> getOneById(@PathVariable Long id){
        return userService.getOneById(id);
    }
}
