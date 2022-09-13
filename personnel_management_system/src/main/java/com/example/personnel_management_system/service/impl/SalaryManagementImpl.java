package com.example.personnel_management_system.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.extra.spring.SpringUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.personnel_management_system.config.myException.MyException;
import com.example.personnel_management_system.mapper.SalaryManagementMapper;
import com.example.personnel_management_system.pojo.bo.SalaryManagementBo;
import com.example.personnel_management_system.pojo.po.EmployeeManagement;
import com.example.personnel_management_system.pojo.po.SalaryManagement;
import com.example.personnel_management_system.pojo.vo.ResultVo;
import com.example.personnel_management_system.pojo.vo.SalaryManagementVo;
import com.example.personnel_management_system.service.EmployeeManagementService;
import com.example.personnel_management_system.service.SalaryManagementService;
import com.example.personnel_management_system.util.FileUtils;
import com.example.personnel_management_system.util.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName SalaryManagementImpl
 * @Description ToDo
 * @Author lirw
 * @Date 2022/9/9 16:14
 **/
@Slf4j
@Service
public class SalaryManagementImpl extends ServiceImpl<SalaryManagementMapper, SalaryManagement> implements SalaryManagementService {
    @Autowired
    @Lazy
    EmployeeManagementService employeeManagementService;


    @Override
    public List<SalaryManagementVo> getSalaryList() {
        List<SalaryManagement> salaryManagements = list();

        List<SalaryManagementVo> salaryManagementVos = new ArrayList<>();
        for (SalaryManagement salaryManagement:salaryManagements){
            SalaryManagementVo salaryManagementVo = new SalaryManagementVo();
            BeanUtils.copyProperties(salaryManagement,salaryManagementVo);
            QueryWrapper<EmployeeManagement> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id",salaryManagement.getEmployeeId());
            EmployeeManagement employee = employeeManagementService.getOne(queryWrapper);
            salaryManagementVo.setEmployeeName(employee.getEmployeeName());
            salaryManagementVos.add(salaryManagementVo);
        }
        return salaryManagementVos;
    }

    @Override
    public SalaryManagement getOneSalary(Long id) {
        QueryWrapper<SalaryManagement> salaryManagementQueryWrapper = new QueryWrapper<>();
        salaryManagementQueryWrapper.eq("employee_id",id);

        return getOne(salaryManagementQueryWrapper);
    }

    @Override
    public ResultVo<Object> printWorkbook(HttpServletResponse response) throws IOException {

        FileInputStream in = null;
        BufferedInputStream bis = null;
        ServletOutputStream os=null;
        List<SalaryManagementVo> salaryList = getSalaryList();
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("统计表");
        String filename="工资报表"+System.currentTimeMillis()+".xlsx";
        String filepath = FileUtils.getFilepath(filename);
        log.info("下载的文件地址为:"+filepath);
        String folderPath = FileUtils.getPathWithOutName(filepath);
        File folder = new File(folderPath);
        if (!folder.exists()){
            folder.mkdirs();
        }
        File file = new File(filepath);
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(filepath);
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(filename, "UTF-8"));
        Row rowName = sheet.createRow(0);
        rowName.createCell(0).setCellValue("员工姓名");
        rowName.createCell(1).setCellValue("基本工资");
        rowName.createCell(2).setCellValue("事病假");
        rowName.createCell(3).setCellValue("加班工资");
        rowName.createCell(4).setCellValue("实际工资");
        int i= 1;
        for (SalaryManagementVo salaryManagementVo:salaryList){
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(salaryManagementVo.getEmployeeName());
            row.createCell(1).setCellValue(salaryManagementVo.getBasePay().toString());
            if (ObjectUtil.isNotNull(salaryManagementVo.getHoliday())){
                row.createCell(2).setCellValue(salaryManagementVo.getHoliday().toString());
            }else {
                row.createCell(2).setCellValue("");
            }
            if (ObjectUtil.isNotNull(salaryManagementVo.getOvertime())){
                row.createCell(3).setCellValue(salaryManagementVo.getOvertime().toString());
            }else {
                row.createCell(3).setCellValue("");
            }
            if (ObjectUtil.isNotNull(salaryManagementVo.getNetSalary())){
                row.createCell(4).setCellValue(salaryManagementVo.getNetSalary().toString());
            }else {
                row.createCell(4).setCellValue("");
            }
            i++;
        }
        try {
            workbook.write(fileOutputStream);
        }catch (IOException e){
            throw new MyException(500,e.toString());
        }finally {
            fileOutputStream.flush();
            fileOutputStream.close();
        }


        try {
            os = response.getOutputStream();
            in = new FileInputStream(file);
            bis = new BufferedInputStream(in, 1024 * 10);
            byte[] buf = new byte[1024 * 10];
            int len = 0;
            while ((len = bis.read(buf, 0, 1024 * 10)) > 0) {
                os.write(buf, 0, len);
            }
        }catch (IOException e){
            throw new MyException(500,e.toString());
        }finally {
            if (bis != null) {
                bis.close();
            }
            if (in != null) {
                in.close();
            }
            if (os != null) {
                os.close();
            }
        }


        return ResultUtil.success();
    }
}
