package com.atguigu.mpdemo1010;

import com.atguigu.mpdemo1010.entity.dept;
import com.atguigu.mpdemo1010.mapper.userMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.util.*;

@SpringBootTest
public class Mpdemo1010ApplicationTests {
    @Autowired
    private userMapper userMapper;
    //测试 查询user 表中的 数据
    @Test
   public void contextLoads() {
        List<dept> users = userMapper.selectList(null);
        dept dept = new dept();
        dept.setDeptno(null);
        dept.setDname("李思思");
        dept.setLoc("哈哈哈哈");
        int insert = userMapper.insert(dept);
        System.out.println(insert);
        System.out.println(users);
    }
    /*
    * 多个id批量查询
    * */
    @Test
    public void modeByidSelect() {
        //传入值是list集合
        List<dept> users = userMapper.selectBatchIds(Arrays.asList(10,20,30));
        System.out.println(users);
    }
    /*
    * 通过map封装查询条件
    * */
    @Test
    public void selectByMap() {
        //传入值是map集合
        HashMap<String, Object> map = new HashMap<>();
        map.put("deptno","53");
        map.put("loc","哈哈哈哈");
        List<dept> depts = userMapper.selectByMap(map);
        System.out.println(depts);

    }
    //修改操作 (自动填充修改)
    @Test
    public void updataDept(){
        dept dept = new dept();
        dept.setDeptno(10);
        dept.setDname("那那那你呢");
        int i = userMapper.updateById(dept);
        System.out.println(i);
    }

    //自动填充填充
    @Test
    public void autoUpdata() {
        dept dept = new dept();
        dept.setDname("李四");
        dept.setLoc("哈哈哈哈");
//        dept.setCreateTime(new Date());
//        dept.setUpdataTime(new Date());
        int insert = userMapper.insert(dept);
        System.out.println(insert);

    }

/*
* 乐观锁 (测试不通过)
* */
    @Test
    public void versionTest() {
        dept dept1 = userMapper.selectById(50);//根据id 查询数据
//        dept1.setDname("李死死死");
        dept1.setLoc("hahahh1");
         userMapper.updateById(dept1);//修改数据 测试乐观锁;
    }

    /*
     * 分页查询
     * */
    @Test
    public void testPage() {
        //1.创建page对象
        //传入两个参数 ,当前页和每页显示的记录数
        Page<dept> page = new Page<>(1,3);
        //调用mp分页查询的方法
        //调用mp分页查询的过程中,底层封装
        //吧分页所有数据封装到page对象中
         this.userMapper.selectPage(page, null);
        //通过page对象获取分页数据
        System.out.println(page.getCurrent());//当前页
        System.out.println(page.getRecords());//每页数据list集合
        System.out.println(page.getSize());//每页显示的记录数
        System.out.println(page.getTotal());//总记录数
        System.out.println(page.getPages());//总页数

        System.out.println(page.hasNext());//是否有下一页
        System.out.println(page.hasPrevious());//是否有上一页
    }


    /*
     * 简单删除
     * */
    @Test
    public void deletedByID() {
        int i = userMapper.deleteById("50");//删除
        userMapper.deleteBatchIds(Arrays.asList(49,53)); //批量删除
        System.out.println(i);
    }
    /*
     * 逻辑删除
     * */
    @Test
    public void deletedBy() {
        int i = userMapper.deleteById("10");
        System.out.println(i);
    }

    @Test
    public void queryWrapper() {
        QueryWrapper<dept> wrapper = new QueryWrapper<>();
        //通过QueryWrapper来操作
        //ge gt le lt
        //第一个参数字段名称  ,第二个参数设置值
//        wrapper.ge("deptno","30");
//        List<dept> depts = userMapper.selectList(wrapper);
//        System.out.println(depts);
        //eq 等于 ne 不等于 between  like orderBy desc
//        wrapper.eq("dname","李思思");
//        List<dept> depts1 = userMapper.selectList(wrapper);
//        System.out.println(depts1);

        //last 在最后拼接sql 语句
        wrapper.last("and deptno> 30 ORDER BY DEPTNO desc ");

        List<dept> depts = userMapper.selectList(wrapper);
        System.out.println(depts);

        //查询指定的列
//        wrapper.select("deptno","dname");
//        wrapper.eq("deptno",30);
//        List<dept> depts1 = userMapper.selectList(wrapper);
//        System.out.println(depts1);

    }
}
