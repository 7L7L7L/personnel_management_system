package com.example.personnel_management_system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.personnel_management_system.mapper.SalaryManagementMapper;
import com.example.personnel_management_system.pojo.po.SalaryManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.SalaryManagementService;
import org.springframework.stereotype.Service;

/**
 * @ClassName SalaryManagementImpl
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/9 16:14
 **/
@Service
public class SalaryManagementImpl extends ServiceImpl<SalaryManagementMapper, SalaryManagement> implements SalaryManagementService {


    @Override
    public SalaryManagement getOneSalary(Long id) {
        QueryWrapper<SalaryManagement> salaryManagementQueryWrapper = new QueryWrapper<>();
        salaryManagementQueryWrapper.eq("employee_id",id);

        return getOne(salaryManagementQueryWrapper);
    }
}
