package com.example.personnel_management_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lirw
 */
@MapperScan("com.example.personnel_management_system.mapper")
@SpringBootApplication(scanBasePackages = {"com.example.personnel_management_system"})
public class PersonnelManagementSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersonnelManagementSystemApplication.class, args);
    }

}
