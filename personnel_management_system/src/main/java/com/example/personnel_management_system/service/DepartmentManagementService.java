package com.example.personnel_management_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.personnel_management_system.pojo.bo.DepartmentManagementBo;
import com.example.personnel_management_system.pojo.po.DepartmentManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;

public interface DepartmentManagementService extends IService<DepartmentManagement> {
     ResultVo<Object> addOne(DepartmentManagementBo departmentManagementBo);
     ResultVo<Object> deleteOne(DepartmentManagementBo departmentManagementBo);
     ResultVo<Object> updateOne(DepartmentManagementBo departmentManagementBo);
     ResultVo<Object> getList();

    /**
     * 查看部门下所有员工
     */
     ResultVo<Object> getAllEmployeeManagement(Long id);


}
