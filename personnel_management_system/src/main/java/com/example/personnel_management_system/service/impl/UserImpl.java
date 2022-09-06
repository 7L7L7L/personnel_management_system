package com.example.personnel_management_system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.mapper.UserMapper;
import com.example.personnel_management_system.pojo.po.User;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.UserService;
import com.example.personnel_management_system.util.JwtUtil;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserImpl
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/2 13:19
 **/
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final JwtUtil jwtUtil;

    public UserImpl(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public ResultVo<Object> login(User user) {
        User user1 = getUser(user);
        if (ObjectUtil.isNotNull(user1)){

            return ResultUtil.success(jwtUtil.generateJwt(user1.getId(), user1.getUsername()));

        }
        return ResultUtil.error(300,"用户名或密码错误");
    }

    @Override
    public ResultVo<Object> register(User user) {
        if (user.getPassword().length()<6){
            return ResultUtil.error(ResultEnum.PASSWORD_LENGTH_IS_LESS_THEN_SIX);
        }
        save(user);
        return ResultUtil.success();
    }

    @Override
    public ResultVo<Object> updatePassword(User user) {
        if (user.getPassword().length()<6){
            return ResultUtil.error(ResultEnum.PASSWORD_LENGTH_IS_LESS_THEN_SIX);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",user.getId());
        User one = getOne(queryWrapper);
        if (one.getPassword().equals(user.getPassword())){
            return ResultUtil.error(ResultEnum.PASSWORD_IS_SAME);
        }
        updateById(user);
        return ResultUtil.success();
    }

    public User getUser(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername()).eq("password",user.getPassword()).eq("is_admin",user.getIsAdmin());
        User one = getOne(queryWrapper);
        return one;
    }

}
