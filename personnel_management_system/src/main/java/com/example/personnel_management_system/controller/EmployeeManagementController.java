package com.example.personnel_management_system.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.config.myException.MyException;
import com.example.personnel_management_system.pojo.bo.EmployeeManagementBo;
import com.example.personnel_management_system.pojo.po.EmployeeManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.EmployeeManagementService;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;


import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName EmployeeManagementController
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 10:39
 **/

@RestController
@RequestMapping("/employeeManagement")
public class EmployeeManagementController {
    private final EmployeeManagementService employeeManagementService;

    public EmployeeManagementController(EmployeeManagementService employeeManagementService) {

        this.employeeManagementService = employeeManagementService;
    }

    @PostMapping("/addOne")
    public ResultVo<Object> addOne(EmployeeManagementBo employeeManagementBo){
//        System.out.println(employeeManagementBo);

        try {
            return  employeeManagementService.addEmployee(employeeManagementBo);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(e);
        }catch (IOException e){
            e.printStackTrace();
            return ResultUtil.error(1024,e.toString());
        }
    }
    @GetMapping("/getList")
    public ResultVo<Object> getList(){

        return ResultUtil.success(employeeManagementService.getEmployees());
    }
    @PostMapping("/deleteEmployee")
    public ResultVo<Object> deleteEmployee(EmployeeManagementBo employeeManagementBo){
        return employeeManagementService.deleteEmployee(employeeManagementBo.getId());
    }
    @PostMapping("/updateEmployee")
    public ResultVo<Object> updateEmployee(EmployeeManagementBo employeeManagementBo){
        try {
            return employeeManagementService.updateEmployee(employeeManagementBo);
        } catch (MyException e) {
            e.printStackTrace();
            return ResultUtil.error(e);
        }catch (IOException e){
            e.printStackTrace();
            return ResultUtil.error(1024,e.toString());
        }
    }
    @PostMapping("/upload")
    public ResultVo<Object> upload(@RequestParam("file")  MultipartFile multipartFile){

        if (ObjectUtil.isNull(multipartFile) ){
            return ResultUtil.error(500,"文件空");
        }
        try {
            return employeeManagementService.upload(multipartFile);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return ResultUtil.error();
    }
    @GetMapping("/getUuid/{id}")
    public ResultVo<Object> getUuid(@PathVariable Long id){
        QueryWrapper<EmployeeManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",id);
        EmployeeManagement one = employeeManagementService.getOne(queryWrapper);
        if (ObjectUtil.isNotNull(one)){
            return ResultUtil.success(one.getUuid());
        }
        else {
            return ResultUtil.error();
        }
    }
}
