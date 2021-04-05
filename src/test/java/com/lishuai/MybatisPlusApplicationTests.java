package com.lishuai;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lishuai.common.enums.GenderEnum;
import com.lishuai.entity.User;
import com.lishuai.mapper.UserMapper;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void query() {
        //无条件查询
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    void insert(){
        User user = new User();
        user.setName("yyyy");
        user.setAge(11);
        user.setGender(GenderEnum.MAN);
        userMapper.insert(user);
    }

    @Test
    void update(){
        User user = userMapper.selectById(1);
        user.setName("李da帅");
        userMapper.updateById(user);
    }

    @Test
    void delete(){
        userMapper.deleteById(1);
    }

    @Test
    void selectList(){
        //QueryWrapper用来设置逻辑
        QueryWrapper queryWrapper = new QueryWrapper();
        //条件查询,name等于Jack
//        queryWrapper.eq("name","Jack");

        //条件查询,name等于Jack而且age等于32
//        HashMap<String,Object> map = new HashMap<>();
//        map.put("name","Jack");
//        map.put("age",32);
//        queryWrapper.allEq(map);

        //条件查询,age大于20,gt：大于,lt:小于,ne:不等于,ge:大于等于
//        queryWrapper.gt("age",20);

        //条件查询,模糊查询,%value%，likeLeft:%value，likeRight:value%
//        queryWrapper.like("name","y");

        //条件查询，子查询：SELECT * FROM user WHERE age IN (select age from user where age>=20)
//        queryWrapper.inSql("age","select age from user where age>=20");

        //条件查询，id>2,按age升序排列
        queryWrapper.orderByAsc("age");
        queryWrapper.having("id>2");

        userMapper.selectList(queryWrapper);
    }

    @Test
    void selectById(){
        //userMapper.selectById(2);
        //多id查询：SELECT * FROM user WHERE id IN ( 1 , 2 )
//        userMapper.selectBatchIds(Arrays.asList(1,2));

        //分页查询,设置起始页,每页容量
        Page<User> page = new Page<>(1,2);
        //查询条件为空
        Page<User> result = userMapper.selectPage(page,null);
        //当前页记录的数量
        System.out.println(result.getSize());
        //记录总数
        System.out.println(result.getTotal());
        //当前页记录
        result.getRecords().forEach(System.out::println);

    }
}
