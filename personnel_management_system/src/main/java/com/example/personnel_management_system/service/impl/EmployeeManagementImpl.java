package com.example.personnel_management_system.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.config.myException.MyException;
import com.example.personnel_management_system.mapper.EmployeeManagementMapper;
import com.example.personnel_management_system.pojo.bo.EmployeeManagementBo;
import com.example.personnel_management_system.pojo.po.EmployeeManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.EmployeeManagementService;
import com.example.personnel_management_system.util.FileUtils;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName EmployeeManagementImpl
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 10:04
 **/
@Service
public class EmployeeManagementImpl extends ServiceImpl<EmployeeManagementMapper, EmployeeManagement> implements EmployeeManagementService {

    @Override
    public ResultVo<Object> addEmployee(EmployeeManagementBo employeeManagementBo) throws IOException {
        EmployeeManagement employee = new EmployeeManagement();
        employee.setEmployeeName(employeeManagementBo.getEmployeeName());
        employee.setEmployeeSex(employeeManagementBo.getEmployeeSex());
        employee.setEmployeeTelephone(employeeManagementBo.getEmployeeTelephone());
        employee.setEmployeeAddress(employeeManagementBo.getEmployeeAddress());


        if (ObjectUtil.isNotNull(employeeManagementBo.getImage())){
            if (StrUtil.isEmpty( employeeManagementBo.getFileName())){
                return ResultUtil.error(ResultEnum.FILENAME_IS_EMPTY);
            }
            String fileName = employeeManagementBo.getFileName();
            MultipartFile multipartFile = employeeManagementBo.getImage();
            String filepath = FileUtils.getFilepath(fileName);
             createFile(filepath,multipartFile);
            employee.setEmployeeImageAddress(filepath);
        }

        boolean b = save(employee);
        if (b){
            return ResultUtil.success();
        }
        return ResultUtil.error();
    }

    @Override
    public ResultVo<Object> deleteEmployee(Long id) {
        boolean b = removeById(id);
        if (b){
            return ResultUtil.success();
        }
        return ResultUtil.error();
    }

    @Override
    public ResultVo<Object> updateEmployee(EmployeeManagementBo employeeManagementBo) throws IOException {
        QueryWrapper<EmployeeManagement> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("id",employeeManagementBo.getId());
        EmployeeManagement one = getOne(queryWrapper);
        System.out.println(one);
        one.setEmployeeName(employeeManagementBo.getEmployeeName());
        one.setEmployeeSex(employeeManagementBo.getEmployeeSex());
        one.setEmployeeTelephone(employeeManagementBo.getEmployeeTelephone());
        one.setEmployeeAddress(employeeManagementBo.getEmployeeAddress());
        if (ObjectUtil.isNotNull(employeeManagementBo.getImage())){
            String fileName = employeeManagementBo.getFileName();
            if (StrUtil.isEmpty(fileName)){
                return ResultUtil.error(ResultEnum.FILENAME_IS_EMPTY);
            }
            MultipartFile multipartFile = employeeManagementBo.getImage();
            String filepath =one.getEmployeeImageAddress();
            File file = new File(filepath);
            String newFilepath=FileUtils.getPathWithOutName(one.getEmployeeImageAddress())+File.separator+fileName;
            boolean delete = file.delete();
            if (delete){
                boolean b = createFile(newFilepath, multipartFile);
                if (b){
                    one.setEmployeeImageAddress(newFilepath);
                }else {
                    return ResultUtil.error(ResultEnum.FILE_CREATION_FAILED);
                }

            }else {
                return ResultUtil.error(ResultEnum.FILE_DELETE_FAILED);
            }
        }
        boolean b = updateById(one);
        if (b){
            return ResultUtil.success();
        }
        return ResultUtil.error();
    }

    @Override
    public List<EmployeeManagement> getEmployees() {

        return list();
    }
    public static boolean createFile(String filepath,MultipartFile multipartFile) throws IOException {

        File file=new File(filepath);
        if (!file.exists()){
            file.mkdirs();
        }
        try {
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
            throw new MyException(ResultEnum.FILE_CREATION_FAILED);

        }
        return true;
    }
}
