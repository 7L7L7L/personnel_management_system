package com.example.personnel_management_system.pojo.vo;

import com.example.personnel_management_system.pojo.po.SalaryManagement;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName SalaryManagementVo
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/9 16:09
 **/
@Data
public class SalaryManagementVo extends SalaryManagement {

    private String employeeName;
    private BigDecimal basePay;
    private BigDecimal holiday;
    private BigDecimal overtime;
    private BigDecimal netSalary;
    private Long uuid;
}
