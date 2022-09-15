package com.example.personnel_management_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.personnel_management_system.mapper.OvertimeManagementMapper;
import com.example.personnel_management_system.pojo.bo.OvertimeManagementBo;
import com.example.personnel_management_system.pojo.po.*;
import com.example.personnel_management_system.pojo.vo.OvertimeManagementVo;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.EmployeeManagementService;
import com.example.personnel_management_system.service.OvertimeManagementService;
import com.example.personnel_management_system.service.SalaryManagementService;
import com.example.personnel_management_system.service.UserService;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName OvertimeManagementImpl
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/15 12:41
 **/
@Service
public class OvertimeManagementImpl extends ServiceImpl<OvertimeManagementMapper, OvertimeManagement> implements OvertimeManagementService {
    private final OvertimeManagementMapper overtimeManagementMapper;
    private final EmployeeManagementService employeeManagementService;
    private final UserService userService;
    private final SalaryManagementService salaryManagementService;

    public OvertimeManagementImpl(OvertimeManagementMapper overtimeManagementMapper,
                                  EmployeeManagementService employeeManagementService,
                                  UserService userService,
                                  SalaryManagementService salaryManagementService) {
        this.overtimeManagementMapper = overtimeManagementMapper;
        this.employeeManagementService = employeeManagementService;
        this.userService = userService;
        this.salaryManagementService = salaryManagementService;
    }

    @Override
    public List<OvertimeManagementVo> getOvertimeList() {
        QueryWrapper<OvertimeManagement> overtimeManagementQueryWrapper = new QueryWrapper<>();
        overtimeManagementQueryWrapper.orderByDesc("employee_id");
        List<OvertimeManagement> overtimeManagements = overtimeManagementMapper.selectList(overtimeManagementQueryWrapper);
        List<OvertimeManagementVo> overtimeManagementVos = new ArrayList<>();
        for (OvertimeManagement overtimeManagement:overtimeManagements){
            QueryWrapper<EmployeeManagement> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",overtimeManagement.getEmployeeId());
            EmployeeManagement employeeManagement = employeeManagementService.getOne(queryWrapper);
            OvertimeManagementVo overtimeManagementVo = new OvertimeManagementVo();
            BeanUtils.copyProperties(overtimeManagement,overtimeManagementVo);
            overtimeManagementVo.setEmployeeName(employeeManagement.getEmployeeName());
            overtimeManagementVos.add(overtimeManagementVo);
        }
        return overtimeManagementVos;
    }

    @Override
    public ResultVo<Object> getOvertimeById(Long userId) {
        //先通过用户id获得员工列表中的id
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id",userId);
        User user = userService.getOne(userQueryWrapper);
        QueryWrapper<OvertimeManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("employee_id",user.getEmployeeId());
        List<OvertimeManagement> overtimeManagements = overtimeManagementMapper.selectList(queryWrapper);
        List<OvertimeManagementVo> overtimeManagementVos = new ArrayList<>();
        QueryWrapper<EmployeeManagement> employeeManagementQueryWrapper = new QueryWrapper<>();
        employeeManagementQueryWrapper.eq("id",user.getEmployeeId());
        EmployeeManagement employeeManagement = employeeManagementService.getOne(employeeManagementQueryWrapper);
        for (OvertimeManagement overtimeManagement:overtimeManagements){
            OvertimeManagementVo overtimeManagementVo = new OvertimeManagementVo();
            BeanUtils.copyProperties(overtimeManagement,overtimeManagementVo);
            overtimeManagementVo.setEmployeeName(employeeManagement.getEmployeeName());
            overtimeManagementVos.add(overtimeManagementVo);
        }
        return ResultUtil.success(overtimeManagementVos);
    }

    @Override
    public ResultVo<Object> addOvertime(OvertimeManagementBo overtimeManagementBo) {
        OvertimeManagement overtimeManagement = new OvertimeManagement();

        BeanUtils.copyProperties(overtimeManagementBo,overtimeManagement);
        //先通过用户id获得员工列表中的id
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id",overtimeManagementBo.getEmployeeId());
        User user = userService.getOne(userQueryWrapper);
        overtimeManagement.setEmployeeId(user.getEmployeeId());

        boolean b = save(overtimeManagement);
        if (b){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }

    @Override
    public ResultVo<Object> deleteOvertime(Long id) {
        boolean b = removeById(id);
        if (b){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }

    @Override
    public ResultVo<Object> updateOvertime(OvertimeManagementBo overtimeManagementBo) {
        QueryWrapper<OvertimeManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",overtimeManagementBo.getId());
        OvertimeManagement one = getOne(queryWrapper);

        BeanUtils.copyProperties(overtimeManagementBo,one);

        boolean b = updateById(one);
        if (b){
            return ResultUtil.success();
        }else {
            return ResultUtil.error();
        }
    }

    @Override
    public ResultVo<Object> allowOvertime(Long id, Integer isAllow) {
        QueryWrapper<OvertimeManagement> overtimeManagementQueryWrapper = new QueryWrapper<>();
        overtimeManagementQueryWrapper.eq("id", id);
        OvertimeManagement one = getOne(overtimeManagementQueryWrapper);
        Long from = one.getOvertimeFrom().atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
        Long to = one.getOvertimeTo().atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
        one.setIsAllow(isAllow);
        if (isAllow == 0) {

            boolean b = updateById(one);
            if (b){
                return ResultUtil.success("审批成功");
            }else {
                return ResultUtil.error(1400,"审批失败");
            }
        }
        SalaryManagement oneSalary = salaryManagementService.getOneSalary(one.getEmployeeId());


            BigDecimal overtimePay = BigDecimal.valueOf((((to - from)/3600000))* 10);
            oneSalary.setOvertime(oneSalary.getHoliday().add(overtimePay));
            oneSalary.setNetSalary(oneSalary.getNetSalary().add(overtimePay));
            boolean update = salaryManagementService.updateById(oneSalary);
            boolean b = updateById(one);
            if (b&update){
                return ResultUtil.success("审批成功");
            }else {
                return ResultUtil.error(1400,"审批失败");
            }

    }
}
