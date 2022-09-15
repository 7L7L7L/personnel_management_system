package com.example.personnel_management_system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.personnel_management_system.pojo.bo.HolidayManagementBo;
import com.example.personnel_management_system.pojo.bo.OvertimeManagementBo;
import com.example.personnel_management_system.pojo.po.OvertimeManagement;
import com.example.personnel_management_system.pojo.vo.HolidayManagementVo;
import com.example.personnel_management_system.pojo.vo.OvertimeManagementVo;
import com.example.personnel_management_system.pojo.vo.ResultVo;

import java.util.List;

public interface OvertimeManagementService extends IService<OvertimeManagement> {

    List<OvertimeManagementVo> getOvertimeList();

    ResultVo<Object> getOvertimeById(Long userId);

    ResultVo<Object> addOvertime(OvertimeManagementBo overtimeManagementBo);

    ResultVo<Object> deleteOvertime(Long id);

    ResultVo<Object> updateOvertime(OvertimeManagementBo overtimeManagementBo);

    ResultVo<Object> allowOvertime(Long id , Integer isAllow);
}
