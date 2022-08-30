package com.example.personnel_management_system.config.mybatisplus;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;


/**
 * @author lirw
 */
@Component
public class MetaHandler  implements MetaObjectHandler {
    /**
     * 新增数据执行
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        this.fillStrategy(metaObject, "createName", "李瑞文");
        this.fillStrategy(metaObject, "createTime", LocalDateTime.now());
    }

    /**
     * 更新数据执行
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
            this.fillStrategy(metaObject, "updateName","李瑞文");
        this.fillStrategy(metaObject, "updateTime", LocalDateTime.now());
    }
}
