package com.atguigu.mpdemo1010.config;

import com.atguigu.mpdemo1010.entity.dept;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.aop.interceptor.PerformanceMonitorInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@MapperScan("com.atguigu.mpdemo1010") //注解 找到mapper 接口
public class MpConfig {
    /*
    * 乐观锁插件
    * */
//    @Bean
////    public OptimisticLockerInnerInterceptor optimisticLockerInnerInterceptor(){
////        System.out.println("乐观锁插件");
////    return new OptimisticLockerInnerInterceptor();
////    }
    @Bean
    public OptimisticLockerInterceptor optimisticLoker() {
        return new OptimisticLockerInterceptor();
    }

/*
 *
 * 分页插件
 * */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        System.out.println("执行了");
        return new PaginationInterceptor();
    }
/*
*
* 邏輯刪除插件(方法不确定) 移除
* */
// @Bean
//    public LogicDeleteByIdWithFill sqlInjector() {
//     System.out.println("delete Byid 置信那个了");
//        return new LogicDeleteByIdWithFill();
//    }


    /*
    * sql性能分析 插件   移除
    *   开发环境使用,线上不推荐 maxTime值得是 sql最长执行时间
    * */

    /*
    * queryWrapper
    * mp实现复杂的查询操作
    *
    * */


}
