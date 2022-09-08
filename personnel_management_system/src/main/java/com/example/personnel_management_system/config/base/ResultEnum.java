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
    FILE_DELETE_FAILED(1200,"照片删除失败"),
    PASSWORD_LENGTH_IS_LESS_THEN_SIX(400,"密码长度小于6"),
    PASSWORD_IS_SAME(600,"密码与上次一致"),
    DEPARTMENT_IS_EXIST(700,"部门已存在"),
    THE_TOKEN_EXPIRES(2001,"令牌过期"),
    THE_TOKEN_IS_NOT_LEGITIMATE(2002,"令牌不合法"),
    INSUFFICIENT_PERMISSIONS(300,"权限不足"),
    IDENTITY_HAS_EXPIRED(800,"身份已过期，请重新登录！"),
    USERNAME_IS_EXIST(900,"用户名已存在"),
    ID_IS_NULL(1300,"id为空"),
    UUID_IS_ERROR(1500,"uuid错误！请重新输入")
    ;


    ;

    private final Integer code;

    private final String msg;
}
