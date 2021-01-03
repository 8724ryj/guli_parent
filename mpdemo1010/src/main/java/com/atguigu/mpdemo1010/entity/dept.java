package com.atguigu.mpdemo1010.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;

@Data  //自动生成 set get 无参  有参  方法 类名要 对应 数据库的 表名dept

public class dept {
    private  String dname;
    @TableId(type= IdType.AUTO)  //主键策略
    private  Integer deptno;
    private  String loc;

    @TableField(fill=FieldFill.INSERT)
    private Date createTime;

    @TableField(fill=FieldFill.INSERT_UPDATE)
    private  Date updataTime;

    //乐观锁
    @Version
    @TableField(fill=FieldFill.INSERT)
    private Integer version;


    @TableLogic //逻辑删除注解
    private  Integer deleted;
}
