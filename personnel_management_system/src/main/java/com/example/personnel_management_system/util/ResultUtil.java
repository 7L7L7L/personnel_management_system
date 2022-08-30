package com.example.personnel_management_system.util;

import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.config.myException.MyException;
import com.example.personnel_management_system.pojo.vo.ResultVo;

/**
 * @ClassName ResultUtil
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 14:12
 **/
public class ResultUtil {
    public static ResultVo<Object> success(Object object) {
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(ResultEnum.SUCCESS.getCode());
        resultVo.setMsg(ResultEnum.SUCCESS.getMsg());
        resultVo.setData(object);
        return resultVo;
    }
    public static ResultVo<Object> success() {
        return success(null);
    }
    public static ResultVo<Object> error(Integer code, String msg) {
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        return resultVo;
    }
    public static ResultVo<Object> error() {
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(ResultEnum.UNKNOWN_ERROR.getCode());
        resultVo.setMsg(ResultEnum.UNKNOWN_ERROR.getMsg());
        resultVo.setData(null);
        return resultVo;
    }
    public static ResultVo<Object> error(Integer code, String msg, Object object) {
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(code);
        resultVo.setMsg(msg);
        resultVo.setData(object);
        return resultVo;
    }

    public static ResultVo<Object> error(ResultEnum resultEnum) {
        return error(resultEnum.getCode(), resultEnum.getMsg());
    }

    public static ResultVo<Object> error(MyException myException) {
        return error(myException.getCode(), myException.getMessage());
    }

    public static ResultVo<Object> error(ResultEnum resultEnum, Object object) {
        ResultVo<Object> resultVo = new ResultVo<>();
        resultVo.setCode(resultEnum.getCode());
        resultVo.setMsg(resultEnum.getMsg());
        resultVo.setData(object);
        return resultVo;
    }
}
