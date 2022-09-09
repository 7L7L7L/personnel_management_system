package com.example.personnel_management_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.personnel_management_system.pojo.po.SalaryManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;

public interface SalaryManagementService extends IService<SalaryManagement> {

    SalaryManagement getOneSalary(Long id);
}
