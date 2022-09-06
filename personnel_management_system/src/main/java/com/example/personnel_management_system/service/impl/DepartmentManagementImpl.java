package com.example.personnel_management_system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.mapper.DepartmentManagementMapper;
import com.example.personnel_management_system.mapper.EmployeeManagementMapper;
import com.example.personnel_management_system.pojo.bo.DepartmentManagementBo;
import com.example.personnel_management_system.pojo.po.DepartmentManagement;
import com.example.personnel_management_system.pojo.po.EmployeeManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.DepartmentManagementService;
import com.example.personnel_management_system.service.EmployeeManagementService;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class DepartmentManagementImpl extends ServiceImpl<DepartmentManagementMapper, DepartmentManagement> implements DepartmentManagementService {


    private EmployeeManagementMapper employeeManagementMapper;

    public DepartmentManagementImpl(EmployeeManagementMapper employeeManagementMapper) {

        this.employeeManagementMapper = employeeManagementMapper;
    }

    @Override
    public ResultVo<Object> addOne(DepartmentManagementBo departmentManagementBo) {
        DepartmentManagement one = getOne(new QueryWrapper<DepartmentManagement>().eq("department_name", departmentManagementBo.getDepartmentName()));
        if (ObjectUtil.isNotNull(one)){
            return ResultUtil.error(ResultEnum.DEPARTMENT_IS_EXIST);
        }
        DepartmentManagement departmentManagement = new DepartmentManagement();
        BeanUtils.copyProperties(departmentManagementBo,departmentManagement);
        return ResultUtil.success(save(departmentManagement));
    }

    @Override
    public ResultVo<Object> deleteOne(Long id) {
        DepartmentManagement one = getOne(new QueryWrapper<DepartmentManagement>().eq("id",id));
        boolean b = removeById(one);
        if (b){
            return ResultUtil.success();
        }
        return ResultUtil.error();
    }

    @Override
    public ResultVo<Object> updateOne(DepartmentManagementBo departmentManagementBo) {
        DepartmentManagement one = getOne(new QueryWrapper<DepartmentManagement>().eq("id", departmentManagementBo.getId()));
        BeanUtils.copyProperties(departmentManagementBo,one);
        boolean b = updateById(one);
        if (b){
            return ResultUtil.success();
        }
        return ResultUtil.error();
    }

    @Override
    public ResultVo<Object> getList() {
        return ResultUtil.success(list());
    }

    @Override
    public ResultVo<Object> getAllEmployeeManagement(String departmentName) {
        QueryWrapper<EmployeeManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("department_name",departmentName);
        return ResultUtil.success(employeeManagementMapper.selectList(queryWrapper));
    }
//    public String getDepartmentNameById(Long id){
//        QueryWrapper<DepartmentManagement> queryWrapper = new QueryWrapper<>();
//        return getOne(queryWrapper.eq("id",id)).getDepartmentName();
//
//    }
}
