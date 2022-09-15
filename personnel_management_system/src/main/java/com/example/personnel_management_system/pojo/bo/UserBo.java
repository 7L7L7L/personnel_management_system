package com.example.personnel_management_system.pojo.bo;

import com.example.personnel_management_system.pojo.po.User;
import lombok.Data;

/**
 * @ClassName UserBo
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/15 16:17
 **/
@Data
public class UserBo extends User {

    private String oldPassword;
}
