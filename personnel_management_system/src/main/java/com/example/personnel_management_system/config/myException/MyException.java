package com.example.personnel_management_system.config.myException;

import com.example.personnel_management_system.config.base.ResultEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;

/**
 * @ClassName myException
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 14:45
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class MyException extends IOException {
    private Integer code;

    public MyException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    /**
     * @param resultEnum 异常枚举
     * @param addMsg     追加信息
     */
    public MyException(ResultEnum resultEnum, String addMsg) {
        super(addMsg + resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    /**
     * @param code 错误码
     * @param msg  信息
     */
    public MyException(Integer code, String msg) {
        super(msg);
        this.code = code;
    }

}
