package com.atguigu.mpdemo1010.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        //使用 mp实现添加操作 这个方法执行
        //根据名称设置属性值
        this.setFieldValByName("createTime",new Date(),metaObject);
        this.setFieldValByName("updataTime",new Date(),metaObject);
        this.setFieldValByName("version",1,metaObject);
        System.out.println("之心了");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
    //使用 mp 实现修改操作 这个方法执行
        this.setFieldValByName("updataTime",new Date(),metaObject);

    }
}
