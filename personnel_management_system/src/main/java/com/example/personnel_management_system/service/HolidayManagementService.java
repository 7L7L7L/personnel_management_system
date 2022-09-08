package com.example.personnel_management_system.service;

import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.personnel_management_system.pojo.bo.HolidayManagementBo;
import com.example.personnel_management_system.pojo.po.HolidayManagement;
import com.example.personnel_management_system.pojo.vo.HolidayManagementVo;
import com.example.personnel_management_system.pojo.vo.ResultVo;

import java.util.List;


/**
 * @author lirw
 */
public interface HolidayManagementService  extends IService<HolidayManagement> {
    List<HolidayManagementVo> getHolidayList();

    ResultVo<Object> getHolidayById(Long userId);

    ResultVo<Object> addHoliday(HolidayManagementBo holidayManagementBo);

    ResultVo<Object> deleteHoliday(Long id);

    ResultVo<Object> updateHoliday(HolidayManagementBo holidayManagementBo);

    ResultVo<Object> allowHoliday(Long id , Integer isAllow);



}
