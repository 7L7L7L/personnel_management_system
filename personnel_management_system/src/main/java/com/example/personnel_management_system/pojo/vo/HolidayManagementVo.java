package com.example.personnel_management_system.pojo.vo;

import com.example.personnel_management_system.pojo.po.HolidayManagement;
import lombok.Data;

/**
 * @ClassName HolidayManagementVo
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/8 9:22
 **/
@Data
public class HolidayManagementVo extends HolidayManagement {

    private String employeeName;
}
