package com.example.personnel_management_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.personnel_management_system.mapper.HolidayManagementMapper;
import com.example.personnel_management_system.pojo.bo.HolidayManagementBo;
import com.example.personnel_management_system.pojo.po.EmployeeManagement;
import com.example.personnel_management_system.pojo.po.HolidayManagement;
import com.example.personnel_management_system.pojo.po.User;
import com.example.personnel_management_system.pojo.vo.HolidayManagementVo;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.EmployeeManagementService;
import com.example.personnel_management_system.service.HolidayManagementService;
import com.example.personnel_management_system.service.UserService;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName HolidayManagementImpl
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/6 15:32
 **/
@Service
public class HolidayManagementImpl extends ServiceImpl<HolidayManagementMapper, HolidayManagement> implements HolidayManagementService {
    @Autowired
    private HolidayManagementMapper holidayManagementMapper;
    private EmployeeManagementService employeeManagementService;
    private UserService userService;

    public HolidayManagementImpl(HolidayManagementMapper holidayManagementMapper, EmployeeManagementService employeeManagementService, UserService userService) {
        this.holidayManagementMapper = holidayManagementMapper;
        this.employeeManagementService = employeeManagementService;
        this.userService = userService;
    }

    @Override
    public List<HolidayManagementVo> getHolidayList() {
        QueryWrapper<HolidayManagement> holidayManagementQueryWrapper = new QueryWrapper<>();
        holidayManagementQueryWrapper.orderByDesc("employee_id");
        List<HolidayManagement> holidayManagements = holidayManagementMapper.selectList(holidayManagementQueryWrapper);
        List<HolidayManagementVo> holidayManagementVos = new ArrayList<>();
        for (HolidayManagement holidayManagement:holidayManagements){
            QueryWrapper<EmployeeManagement> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",holidayManagement.getEmployeeId());
            EmployeeManagement employeeManagement = employeeManagementService.getOne(queryWrapper);
            HolidayManagementVo holidayManagementVo = new HolidayManagementVo();
            BeanUtils.copyProperties(holidayManagement,holidayManagementVo);
            holidayManagementVo.setEmployeeName(employeeManagement.getEmployeeName());
            holidayManagementVos.add(holidayManagementVo);
        }

        return holidayManagementVos;
    }

    @Override
    public ResultVo<Object> getHolidayById(Long userId) {
        //先通过用户id获得员工列表中的id
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id",userId);
        User user = userService.getOne(userQueryWrapper);
        QueryWrapper<HolidayManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id",user.getEmployeeId());
        List<HolidayManagement> holidayManagements = holidayManagementMapper.selectList(queryWrapper);
        return ResultUtil.success(holidayManagements);
    }

    @Override
    public ResultVo<Object> addHoliday(HolidayManagementBo holidayManagementBo) {
        HolidayManagement holidayManagement = new HolidayManagement();

        BeanUtils.copyProperties(holidayManagementBo,holidayManagement);
        //先通过用户id获得员工列表中的id
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id",holidayManagementBo.getEmployeeId());
        User user = userService.getOne(userQueryWrapper);
        holidayManagement.setEmployeeId(user.getEmployeeId());

        boolean b = save(holidayManagement);
        if (b){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }

    }

    @Override
    public ResultVo<Object> deleteHoliday(Long id) {

        boolean b = removeById(id);
        if (b){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }

    @Override
    public ResultVo<Object> updateHoliday(HolidayManagementBo holidayManagementBo) {
        QueryWrapper<HolidayManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",holidayManagementBo.getId());
        HolidayManagement one = getOne(queryWrapper);

        BeanUtils.copyProperties(holidayManagementBo,one);

        boolean b = updateById(one);
        if (b){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }

    @Override
    public ResultVo<Object> allowHoliday(Long id,Integer isAllow) {
        QueryWrapper<HolidayManagement> holidayManagementQueryWrapper = new QueryWrapper<>();
        holidayManagementQueryWrapper.eq("id",id);
        HolidayManagement one = getOne(holidayManagementQueryWrapper);
        one.setIsAllow(isAllow);
        if (isAllow==0){
            one.setState(2);
        }
        boolean b = updateById(one);
        if (b){
            return ResultUtil.success("审批成功");
        }else {
            return ResultUtil.error(1400,"审批失败");
        }

    }
}
