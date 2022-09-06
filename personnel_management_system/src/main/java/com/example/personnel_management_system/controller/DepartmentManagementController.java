package com.example.personnel_management_system.controller;

import com.example.personnel_management_system.config.myException.MyException;
import com.example.personnel_management_system.pojo.bo.DepartmentManagementBo;
import com.example.personnel_management_system.pojo.bo.EmployeeManagementBo;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.DepartmentManagementService;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/departmentManagement")
public class DepartmentManagementController {
    private DepartmentManagementService departmentManagementService;

    public DepartmentManagementController(DepartmentManagementService departmentManagementService) {
        this.departmentManagementService = departmentManagementService;
    }

    @GetMapping("/getAllEmployeeManagement/{departmentName}")
    public ResultVo<Object> getAllEmployeeManagement(@PathVariable("departmentName") String departmentName){
        return departmentManagementService.getAllEmployeeManagement(departmentName);
    }
    @GetMapping("/getList")
    public ResultVo<Object> getList(){
        return departmentManagementService.getList();
    }
    @PostMapping("/addOne")
    public ResultVo<Object> addOne(DepartmentManagementBo departmentManagementBo){

            return  departmentManagementService.addOne(departmentManagementBo);

    }
    @PostMapping("/deleteOne/{id}")
    public ResultVo<Object> deleteEmployee(@PathVariable("id") Long id){
        return departmentManagementService.deleteOne(id);
    }
    @PostMapping("/updateOne")
    public ResultVo<Object> updateEmployee(DepartmentManagementBo departmentManagementBo){

            return departmentManagementService.updateOne(departmentManagementBo);

    }
}
