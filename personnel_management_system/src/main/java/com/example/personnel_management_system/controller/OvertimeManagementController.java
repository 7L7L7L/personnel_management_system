package com.example.personnel_management_system.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.pojo.bo.HolidayManagementBo;
import com.example.personnel_management_system.pojo.bo.OvertimeManagementBo;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.HolidayManagementService;
import com.example.personnel_management_system.service.OvertimeManagementService;
import com.example.personnel_management_system.util.JwtUtil;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HolidayManagementController
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/6 15:33
 **/
@RestController
@RequestMapping("/overtimeManagement")
public class OvertimeManagementController {
    private final OvertimeManagementService overtimeManagementService;


    public OvertimeManagementController(OvertimeManagementService overtimeManagementService) {
        this.overtimeManagementService = overtimeManagementService;

    }

    @GetMapping("/getOvertimeList")
   public ResultVo<Object> getOvertimeList(){

        return ResultUtil.success(overtimeManagementService.getOvertimeList()) ;
    }
    @GetMapping("/getOvertimeForOne")
    ResultVo<Object> getOvertimeForOne(HttpServletRequest request){
        String id = request.getHeader("id");
//        String id = RequestUtil.getHeader("id");
        if (StrUtil.isBlank(id)){
            return ResultUtil.error(ResultEnum.IDENTITY_HAS_EXPIRED);
        }
        Long userId= Long.valueOf(id);


        return overtimeManagementService.getOvertimeById(userId);

    }
    @PostMapping("/addOvertime")
    ResultVo<Object> addOvertime(OvertimeManagementBo overtimeManagementBo){

        return overtimeManagementService.addOvertime(overtimeManagementBo);
    }
    @PostMapping("/deleteOvertime/{id}")
    ResultVo<Object> deleteOvertime(@PathVariable Long id){
        if (ObjectUtil.isNull(id)){
            return ResultUtil.error(ResultEnum.ID_IS_NULL);
        }

        return overtimeManagementService.deleteOvertime(id);
    }
    @PostMapping("/updateOvertime")
    ResultVo<Object> updateOvertime(OvertimeManagementBo overtimeManagementBo){
        return overtimeManagementService.updateOvertime(overtimeManagementBo);
    }
    @PostMapping("/allowOvertime/{id}/{isAllow}")
    ResultVo<Object> allowOvertime(@PathVariable Long id,@PathVariable Integer isAllow){
        if (ObjectUtil.isNull(id)){
            return ResultUtil.error(ResultEnum.ID_IS_NULL);
        }
        return overtimeManagementService.allowOvertime(id,isAllow);
    }
}
