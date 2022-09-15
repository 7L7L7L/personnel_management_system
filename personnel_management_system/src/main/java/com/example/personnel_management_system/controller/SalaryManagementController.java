package com.example.personnel_management_system.controller;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.example.personnel_management_system.config.myException.MyException;

import com.example.personnel_management_system.pojo.po.SalaryManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.pojo.vo.SalaryManagementVo;
import com.example.personnel_management_system.service.SalaryManagementService;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName SalaryManagementController
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/13 9:56
 **/
@RestController
@RequestMapping("/salaryManagement")
public class SalaryManagementController {

    SalaryManagementService salaryManagementService;

    public SalaryManagementController(SalaryManagementService salaryManagementService) {
        this.salaryManagementService = salaryManagementService;
    }

    @GetMapping("/getOneSalary/{id}")
    public ResultVo<Object> getOneSalary(@PathVariable Long id){
        SalaryManagement oneSalary = salaryManagementService.getOneSalary(id);
        if (ObjectUtil.isNotNull(oneSalary)){
            return ResultUtil.success(oneSalary);

        }else {
            return ResultUtil.error(500,"信息为空");
        }

    }
    @GetMapping("/getSalaryList")
    public ResultVo<Object> getSalaryList(){
        List<SalaryManagementVo> salaryList = salaryManagementService.getSalaryList();
        if (CollectionUtil.isNotEmpty(salaryList)){
            return ResultUtil.success(salaryList);
        }else {
            return ResultUtil.error(500,"信息为空");
        }

    }
    @GetMapping("/printWorkbook")
    public ResultVo<Object> printWorkbook(HttpServletResponse response){

        try {
            return salaryManagementService.printWorkbook(response);
        } catch (MyException e) {
            return  ResultUtil.error(e);
        }catch (IOException e){

            return ResultUtil.error(new MyException(500,e.toString()));
        }
    }

}
