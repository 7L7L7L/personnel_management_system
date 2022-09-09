package com.example.personnel_management_system.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.personnel_management_system.config.mybatisplus.BaseEntity;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName SalaryManagement
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/9 15:45
 **/
@Data
@TableName("salary_management")
public class SalaryManagement extends BaseEntity<SalaryManagement> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private Long employeeId;
    private BigDecimal basePay;
    private BigDecimal holiday;
    private BigDecimal overtime;
    private BigDecimal netSalary;



}
