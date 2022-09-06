package com.example.personnel_management_system.controller;

import com.example.personnel_management_system.service.HolidayManagementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public HolidayManagementController(HolidayManagementService holidayManagementService) {
        this.holidayManagementService = holidayManagementService;
    }
}
