package com.example.personnel_management_system.config.base;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ResultEuem
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 14:09
 **/
@Getter
@AllArgsConstructor
public enum ResultEnum  {
    /**
     * 返回不同情况得码值与信息
     */
    SUCCESS(200,"成功"),
    UNKNOWN_ERROR(500, "未知错误"),
    FILENAME_IS_EMPTY(1000,"文件名为空"),
    FILE_CREATION_FAILED(1100,"文件创建失败"),
    FILE_DELETE_FAILED(1200,"照片删除失败")

    ;

    private final Integer code;

    private final String msg;
}
