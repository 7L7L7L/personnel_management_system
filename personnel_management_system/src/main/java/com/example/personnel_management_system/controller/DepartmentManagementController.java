package com.example.personnel_management_system.controller;

import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.DepartmentManagementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/departmentManagement")
public class DepartmentManagementController {
    private DepartmentManagementService departmentManagementService;

    public DepartmentManagementController(DepartmentManagementService departmentManagementService) {
        this.departmentManagementService = departmentManagementService;
    }

    @GetMapping("/get/{id}")
    public ResultVo<Object> getAllEmployeeManagement(@PathVariable Long id){
        return departmentManagementService.getAllEmployeeManagement(id);
    }
}
