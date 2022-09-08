package com.example.personnel_management_system.pojo.po;

import com.baomidou.mybatisplus.annotation.*;
import com.example.personnel_management_system.config.mybatisplus.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @ClassName HolidayManagement
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/6 15:27
 **/
@Data
@TableName("holiday_management")
public class HolidayManagement extends BaseEntity<HolidayManagement> {

    @TableId(type = IdType.AUTO)
    private Long id;

    private Long employeeId;
    private String leaveReason;

    private Integer isAllow;

    private Integer state;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime fromTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime toTime;

}
