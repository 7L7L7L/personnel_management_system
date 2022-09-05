package com.example.personnel_management_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.personnel_management_system.config.myException.MyException;
import com.example.personnel_management_system.pojo.bo.EmployeeManagementBo;
import com.example.personnel_management_system.pojo.po.EmployeeManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author lirw
 */
public interface EmployeeManagementService extends IService<EmployeeManagement> {

    ResultVo<Object> addEmployee(EmployeeManagementBo employeeManagementBo) throws IOException;

    ResultVo<Object> deleteEmployee(Long id);

    ResultVo<Object> updateEmployee(EmployeeManagementBo employeeManagementBo) throws IOException;

    List<EmployeeManagement> getEmployees();
    ResultVo<Object> upload(MultipartFile multipartFile) throws MyException;
}
