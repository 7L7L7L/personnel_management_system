package com.example.personnel_management_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.personnel_management_system.config.myException.MyException;

import com.example.personnel_management_system.pojo.po.SalaryManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.pojo.vo.SalaryManagementVo;

import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public interface SalaryManagementService extends IService<SalaryManagement> {

    SalaryManagementVo getOneSalary(Long id);

    List<SalaryManagementVo> getSalaryList();

    ResultVo<Object> printWorkbook(HttpServletResponse response) throws IOException;
}
