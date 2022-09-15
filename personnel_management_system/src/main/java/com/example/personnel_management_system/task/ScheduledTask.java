package com.example.personnel_management_system.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.personnel_management_system.mapper.HolidayManagementMapper;
import com.example.personnel_management_system.pojo.po.HolidayManagement;
import com.example.personnel_management_system.pojo.po.SalaryManagement;
import com.example.personnel_management_system.service.HolidayManagementService;
import com.example.personnel_management_system.service.SalaryManagementService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.math.BigDecimal;
import java.time.ZoneId;
import java.util.List;

/**
 * @ClassName ScheduledTask
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/8 9:54
 **/
@Configuration
public class ScheduledTask {

    private final HolidayManagementMapper holidayManagementMapper;
    private final HolidayManagementService holidayManagementService;
    private final SalaryManagementService salaryManagementService;

    public ScheduledTask(HolidayManagementMapper holidayManagementMapper,
                         HolidayManagementService holidayManagementService,
                         SalaryManagementService salaryManagementService) {
        this.holidayManagementMapper = holidayManagementMapper;
        this.holidayManagementService = holidayManagementService;
        this.salaryManagementService = salaryManagementService;
    }


    @Scheduled(cron = "0 0/10 * * * ?")
    public void scheduledUpdateHolidayStateForUnAllow(){
        QueryWrapper<HolidayManagement> holidayManagementQueryWrapper = new QueryWrapper<>();
        //未审核
        holidayManagementQueryWrapper.eq("is_allow",2);
        List<HolidayManagement> holidayManagements = holidayManagementMapper.selectList(holidayManagementQueryWrapper);
        for (HolidayManagement holidayManagement:holidayManagements){
            Long fromTime = holidayManagement.getFromTime().atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
            Long toTime =holidayManagement.getToTime().atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
            if (System.currentTimeMillis()<fromTime){
                holidayManagement.setState(3);
            }else if (System.currentTimeMillis()>=fromTime&&System.currentTimeMillis()<=toTime){
                // 未审核的 在请假期间
                holidayManagement.setState(3);
            }else {
                holidayManagement.setState(2);
            }
            holidayManagementService.updateById(holidayManagement);
        }

    }
    @Scheduled(cron = "0/5 * * * * ?")
    public void scheduledUpdateHolidayStateForAllow(){
        QueryWrapper<HolidayManagement> holidayManagementQueryWrapper = new QueryWrapper<>();
        //未审核
        holidayManagementQueryWrapper.eq("is_allow",1);
        List<HolidayManagement> holidayManagements = holidayManagementMapper.selectList(holidayManagementQueryWrapper);

        for (HolidayManagement holidayManagement:holidayManagements){
            Long fromTime = holidayManagement.getFromTime().atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
            Long toTime =holidayManagement.getToTime().atZone(ZoneId.of("Asia/Shanghai")).toInstant().toEpochMilli();
            if (System.currentTimeMillis()<fromTime){
                holidayManagement.setState(0);
            }else if (System.currentTimeMillis()>=fromTime&&System.currentTimeMillis()<=toTime){
                // 审核的 在请假期间
                holidayManagement.setState(1);
            }else {
                holidayManagement.setState(2);
            }
            holidayManagementService.updateById(holidayManagement);
        }

    }

    @Scheduled(cron = "0 0 0 1 * ?")
    public void resetSalary(){
        List<SalaryManagement> list = salaryManagementService.list();

        for (SalaryManagement salaryManagement:list){
            salaryManagement.setNetSalary(salaryManagement.getBasePay());
            salaryManagement.setHoliday(BigDecimal.ZERO);
            salaryManagement.setOvertime(BigDecimal.ZERO);
            salaryManagementService.updateById(salaryManagement);
        }

    }
}
