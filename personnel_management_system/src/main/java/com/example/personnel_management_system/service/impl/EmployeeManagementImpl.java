package com.example.personnel_management_system.service.impl;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.config.myException.MyException;
import com.example.personnel_management_system.mapper.EmployeeManagementMapper;
import com.example.personnel_management_system.pojo.bo.EmployeeManagementBo;
import com.example.personnel_management_system.pojo.po.EmployeeManagement;
import com.example.personnel_management_system.pojo.po.HolidayManagement;
import com.example.personnel_management_system.pojo.po.OvertimeManagement;
import com.example.personnel_management_system.pojo.po.SalaryManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.EmployeeManagementService;
import com.example.personnel_management_system.service.HolidayManagementService;
import com.example.personnel_management_system.service.OvertimeManagementService;
import com.example.personnel_management_system.service.SalaryManagementService;
import com.example.personnel_management_system.util.FileUtils;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * @ClassName EmployeeManagementImpl
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 10:04
 **/
@Service
public class EmployeeManagementImpl extends ServiceImpl<EmployeeManagementMapper, EmployeeManagement> implements EmployeeManagementService {


    @Autowired
    SalaryManagementService salaryManagementService;
    @Lazy
    @Autowired
    OvertimeManagementService overtimeManagementService;
    @Lazy
    @Autowired
    HolidayManagementService holidayManagementService;

    @Override
    public ResultVo<Object> addEmployee(EmployeeManagementBo employeeManagementBo) throws IOException {
        EmployeeManagement employee = new EmployeeManagement();
        employee.setEmployeeName(employeeManagementBo.getEmployeeName());
        employee.setEmployeeSex(employeeManagementBo.getEmployeeSex());
        employee.setEmployeeTelephone(employeeManagementBo.getEmployeeTelephone());
        employee.setEmployeeAddress(employeeManagementBo.getEmployeeAddress());
        employee.setDepartmentName(employeeManagementBo.getDepartmentName());
        employee.setEmployeeImageAddress(employeeManagementBo.getEmployeeImageAddress());
        Long uuid = getUuid();
        employee.setUuid(uuid);



        boolean b = save(employee);
        if (b){
            QueryWrapper<EmployeeManagement> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("uuid",uuid);
            EmployeeManagement one = getOne(queryWrapper);
            SalaryManagement salaryManagement = new SalaryManagement();
            salaryManagement.setEmployeeId(one.getId());
            boolean save = salaryManagementService.save(salaryManagement);
            if (save){
                return ResultUtil.success("添加成功,uuid为："+uuid);
            }else {
                return ResultUtil.success("员工添加成功,工资列表添加失败!");

            }

        }
        return ResultUtil.error();
    }




    @Override
    public ResultVo<Object> deleteEmployee(Long id) {


        QueryWrapper<SalaryManagement> salaryManagementQueryWrapper = new QueryWrapper<>();
        salaryManagementQueryWrapper.eq("employee_id",id);
        QueryWrapper<HolidayManagement> holidayManagementQueryWrapper = new QueryWrapper<>();
        QueryWrapper<OvertimeManagement> overtimeManagementQueryWrapper = new QueryWrapper<>();
        holidayManagementQueryWrapper.eq("employee_id",id);
        overtimeManagementQueryWrapper.eq("employee_id",id);
        boolean rs = salaryManagementService.remove(salaryManagementQueryWrapper);
        boolean rh = holidayManagementService.remove(holidayManagementQueryWrapper);
        boolean ro = overtimeManagementService.remove(overtimeManagementQueryWrapper);

        boolean b = removeById(id);
        if (b&&rs&&rh&&ro){
            return ResultUtil.success();
        }
        return ResultUtil.error();
    }

    @Override
    public ResultVo<Object> updateEmployee(EmployeeManagementBo employeeManagementBo) throws IOException {
        QueryWrapper<EmployeeManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",employeeManagementBo.getId());
        EmployeeManagement one = getOne(queryWrapper);
        one.setDepartmentName(employeeManagementBo.getDepartmentName());
        one.setEmployeeName(employeeManagementBo.getEmployeeName());
        one.setEmployeeSex(employeeManagementBo.getEmployeeSex());
        one.setEmployeeTelephone(employeeManagementBo.getEmployeeTelephone());
        one.setEmployeeAddress(employeeManagementBo.getEmployeeAddress());
        one.setEmployeeImageAddress(employeeManagementBo.getEmployeeImageAddress());

        boolean b = updateById(one);
        if (b){
            return ResultUtil.success();
        }
        return ResultUtil.error();
    }

    @Override
    public ResultVo<Object> upload(MultipartFile multipartFile) throws MyException {
        String filepath = FileUtils.getFilepath(multipartFile.getOriginalFilename());
        File file=new File(filepath);
        if (!file.exists()){
            file.mkdirs();
        }
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MyException(ResultEnum.FILE_CREATION_FAILED);

        }

        return ResultUtil.success(FileUtils.getUuidAndName(filepath));
    }

    @Override
    public List<EmployeeManagement> getEmployees() {

        return list();
    }

    public  Long getUuid(){
        Long random= Long.valueOf("1916020"+ RandomUtil.randomLong(999));
        QueryWrapper<EmployeeManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uuid",random);
        EmployeeManagement one = getOne(queryWrapper);
        if (ObjectUtil.isNull(one)){
            return random;
        }else {
            return getUuid();
        }
    }

}
