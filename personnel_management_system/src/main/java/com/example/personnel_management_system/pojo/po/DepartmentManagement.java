package com.example.personnel_management_system.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.personnel_management_system.config.mybatisplus.BaseEntity;
import lombok.Data;

@Data
@TableName("department_management")
public class DepartmentManagement extends BaseEntity<DepartmentManagement> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String departmentName;
    private String departmentInfo;
    private String principal;
}
