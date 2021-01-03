package com.atguigu.mpdemo1010.mapper;

import com.atguigu.mpdemo1010.entity.dept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface userMapper extends BaseMapper<dept> {
    //直接就可以调用 增删改方法
}
