package com.example.personnel_management_system.pojo.po;

import com.baomidou.mybatisplus.annotation.*;
import com.example.personnel_management_system.config.mybatisplus.BaseEntity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName EmployeeManagement
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 9:55
 **/
@Data
@TableName("employee_management")
public class EmployeeManagement extends BaseEntity<EmployeeManagement> {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 员工姓名
     */
    private String employeeName;
    /**
     * 员工性别
     */
    private String employeeSex;
    /**
     * 员工电话
     */
    private String employeeTelephone;
    /**
     * 员工地址
     */
    private String employeeAddress;
    /**
     * 员工图片地址
     */
    private String employeeImageAddress;

    private String departmentName;
}
