package com.example.personnel_management_system.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.personnel_management_system.config.mybatisplus.BaseEntity;
import lombok.Data;

/**
 * @ClassName User
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/30 9:41
 **/
@Data
@TableName("user")
public class User extends BaseEntity<User> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String username;

    private String password;
    private Integer isAdmin;
    private Long employeeId;
}
