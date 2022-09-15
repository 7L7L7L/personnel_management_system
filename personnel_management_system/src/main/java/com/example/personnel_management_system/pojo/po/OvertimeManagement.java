package com.example.personnel_management_system.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.personnel_management_system.config.mybatisplus.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @ClassName OvertimeManagement
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/15 12:35
 **/
@Data
@TableName("overtime_management")
public class OvertimeManagement extends BaseEntity<OvertimeManagement> {

    @TableId(type = IdType.AUTO)
    private Long id ;

    private Long employeeId;

    private Integer isAllow;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime overtimeFrom;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime overtimeTo;
}
