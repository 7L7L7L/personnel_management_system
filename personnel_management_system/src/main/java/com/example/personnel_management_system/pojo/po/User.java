package com.example.personnel_management_system.pojo.po;

import com.example.personnel_management_system.config.mybatisplus.BaseEntity;
import lombok.Data;

/**
 * @ClassName User
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/30 9:41
 **/
@Data
public class User extends BaseEntity<User> {

    private String username;

    private String password;
}
