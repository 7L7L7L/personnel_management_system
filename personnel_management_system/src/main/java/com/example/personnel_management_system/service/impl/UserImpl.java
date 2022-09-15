package com.example.personnel_management_system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.mapper.UserMapper;
import com.example.personnel_management_system.pojo.bo.UserBo;
import com.example.personnel_management_system.pojo.po.EmployeeManagement;
import com.example.personnel_management_system.pojo.po.User;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.EmployeeManagementService;
import com.example.personnel_management_system.service.UserService;
import com.example.personnel_management_system.util.JwtUtil;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserImpl
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/2 13:19
 **/
@Service
public class UserImpl extends ServiceImpl<UserMapper, User> implements UserService {

    private final JwtUtil jwtUtil;
    private  final EmployeeManagementService employeeManagementService;

    public UserImpl(JwtUtil jwtUtil, EmployeeManagementService employeeManagementService) {
        this.jwtUtil = jwtUtil;
        this.employeeManagementService = employeeManagementService;
    }

    @Override
    public ResultVo<Object> login(User user) {
        User user1 = getUser(user);
        if (ObjectUtil.isNotNull(user1)){
            Map<String, Object> map = new HashMap<>();
            map.put("id",user1.getId());
            map.put("jwt",jwtUtil.generateJwt(user1.getId(), user1.getUsername()));
            return ResultUtil.success(map);
        }
        return ResultUtil.error(300,"用户名或密码错误");
    }

    @Override
    public ResultVo<Object> register(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        if (ObjectUtil.isNotNull(getOne(queryWrapper)) ){
            return ResultUtil.error(ResultEnum.USERNAME_IS_EXIST);
        }
        if (user.getPassword().length()<6){
            return ResultUtil.error(ResultEnum.PASSWORD_LENGTH_IS_LESS_THEN_SIX);
        }
        boolean save = save(user);
        if (save){
            return ResultUtil.success();

        }else{
            return ResultUtil.error();

        }
    }

    @Override
    public ResultVo<Object> updatePassword(UserBo user) {
        if (user.getPassword().length()<6){
            return ResultUtil.error(ResultEnum.PASSWORD_LENGTH_IS_LESS_THEN_SIX);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",user.getId());
        User one = getOne(queryWrapper);
        if (!one.getPassword().equals(user.getOldPassword())){
            return ResultUtil.error(ResultEnum.OLD_PASSWORD_IS_ERROR);
        }
        if (one.getPassword().equals(user.getPassword())){
            return ResultUtil.error(ResultEnum.PASSWORD_IS_SAME);
        }
        one.setPassword(user.getPassword());
        updateById(one);
        return ResultUtil.success();
    }

    @Override
    public ResultVo<Object> getOneById(Long id) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id",id);
        User one = getOne(userQueryWrapper);
        if (ObjectUtil.isNotNull(one)){
            return ResultUtil.success(one);
        }else {
            return ResultUtil.error();

        }
    }

    @Override
    public ResultVo<Object> userBind(Long id,Long uuid) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id",id);
        User user = getOne(userQueryWrapper);
        QueryWrapper<EmployeeManagement> employeeManagementQueryWrapper = new QueryWrapper<>();
        employeeManagementQueryWrapper.eq("uuid",uuid);
        EmployeeManagement employeeManagement = employeeManagementService.getOne(employeeManagementQueryWrapper);
        if (ObjectUtil.isNull(employeeManagement)){
            return ResultUtil.error(ResultEnum.UUID_IS_ERROR);
        }else {
            QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("employee_id",employeeManagement.getId());
            User one = getOne(queryWrapper);
            if (ObjectUtil.isNotNull(one)){
                return ResultUtil.error(1600,"该用户已被实名！");
            }
            user.setEmployeeId(employeeManagement.getId());
            boolean b = updateById(user);
            if (b){
                return ResultUtil.success();
            }else {
                return ResultUtil.error();
            }
        }

    }

    public User getUser(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername()).eq("password",user.getPassword()).eq("is_admin",user.getIsAdmin());
        User one = getOne(queryWrapper);
        return one;
    }

}
