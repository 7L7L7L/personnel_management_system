package com.example.personnel_management_system.pojo.bo;

import com.example.personnel_management_system.pojo.po.EmployeeManagement;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName EmployeeManagementBo
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 10:09
 **/
@Data
public class EmployeeManagementBo extends EmployeeManagement {
    /**
     * 照片名称
     */
    private String fileName;

    private  MultipartFile image;
}
