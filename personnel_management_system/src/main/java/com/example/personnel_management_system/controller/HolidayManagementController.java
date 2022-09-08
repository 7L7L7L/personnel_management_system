package com.example.personnel_management_system.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.personnel_management_system.config.base.ResultEnum;
import com.example.personnel_management_system.pojo.bo.HolidayManagementBo;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.service.HolidayManagementService;
import com.example.personnel_management_system.util.JwtUtil;
import com.example.personnel_management_system.util.RequestUtil;
import com.example.personnel_management_system.util.ResultUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @ClassName HolidayManagementController
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/6 15:33
 **/
@RestController
@RequestMapping("/holidayManagement")
public class HolidayManagementController {
    HolidayManagementService holidayManagementService;
    JwtUtil jwtUtil;

    public HolidayManagementController(HolidayManagementService holidayManagementService, JwtUtil jwtUtil) {
        this.holidayManagementService = holidayManagementService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/getHolidayList")
   public ResultVo<Object> getHolidayList(){

        return ResultUtil.success(holidayManagementService.getHolidayList()) ;
    }
    @GetMapping("/getHolidayForOne")
    ResultVo<Object> getHolidayForOne(HttpServletRequest request){
        String id = request.getHeader("id");
//        String id = RequestUtil.getHeader("id");
        if (StrUtil.isBlank(id)){
            return ResultUtil.error(ResultEnum.IDENTITY_HAS_EXPIRED);
        }
        Long userId= Long.valueOf(id);

        return holidayManagementService.getHolidayById(userId);

    }
    @PostMapping("/addHoliday")
    ResultVo<Object> addHoliday(HolidayManagementBo holidayManagementBo){

        return holidayManagementService.addHoliday(holidayManagementBo);
    }
    @PostMapping("/deleteHoliday/{id}")
    ResultVo<Object> deleteHoliday(@PathVariable Long id){
        if (ObjectUtil.isNull(id)){
            return ResultUtil.error(ResultEnum.ID_IS_NULL);
        }

        return holidayManagementService.deleteHoliday(id);
    }
    @PostMapping("/updateHoliday")
    ResultVo<Object> updateHoliday(HolidayManagementBo holidayManagementBo){
        return holidayManagementService.updateHoliday(holidayManagementBo);
    }
    @PostMapping("/allowHoliday/{id}/{isAllow}")
    ResultVo<Object> allowHoliday(@PathVariable Long id,@PathVariable Integer isAllow){
        if (ObjectUtil.isNull(id)){
            return ResultUtil.error(ResultEnum.ID_IS_NULL);
        }
        return holidayManagementService.allowHoliday(id,isAllow);
    }
}
