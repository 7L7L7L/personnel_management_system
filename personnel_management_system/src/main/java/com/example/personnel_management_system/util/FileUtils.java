package com.example.personnel_management_system.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.Arrays;
import java.util.UUID;

/**
 * @ClassName FileUtils
 * @Description ToDo
 * @Author lirw
 * @Date 2022/8/29 11:34
 **/

@Configuration
public class FileUtils {

    private static String path;
    @Value("${file.upload-path}")
    public void setPath(String path){
        FileUtils.path=path;
    }
    public static String getFilepath(String fileName){
        UUID uuid=UUID.randomUUID();
        return path+uuid+File.separator+fileName;
    }
    public static String getPathWithOutName(String filepath){

        filepath=filepath.replaceAll(getFileName(filepath),"");
        filepath=filepath.substring(0,filepath.length()-1);

        return filepath;
    }
    public static String getFileName(String filepath){

        String[] split = filepath.split("\\\\");

        if (ObjectUtil.isNotNull(split)&&split.length>1){
            filepath=split[split.length-1];
        }
        return filepath;
    }



}
