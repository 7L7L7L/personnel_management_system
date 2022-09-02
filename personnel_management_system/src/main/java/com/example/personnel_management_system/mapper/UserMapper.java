package com.example.personnel_management_system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.personnel_management_system.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lirw
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
