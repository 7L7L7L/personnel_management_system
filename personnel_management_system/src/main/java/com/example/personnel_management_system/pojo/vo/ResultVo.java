package com.example.personnel_management_system.pojo.vo;

import lombok.Data;

/**
 * @ClassName ResultVo
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 14:06
 **/
@Data
public class ResultVo<T> {
    private Integer code;
    private String msg;
    private T data;
}
