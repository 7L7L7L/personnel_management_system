package com.example.personnel_management_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.personnel_management_system.pojo.po.User;
import com.example.personnel_management_system.pojo.vo.ResultVo;

/**
 * @author lirw
 */
public interface UserService extends IService<User> {

    ResultVo<Object> login(User user);

    ResultVo<Object> register(User user);

    ResultVo<Object> updatePassword(User user);
}
