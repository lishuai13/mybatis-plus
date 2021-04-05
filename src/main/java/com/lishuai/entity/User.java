package com.lishuai.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.lishuai.common.enums.GenderEnum;
import lombok.Data;

import java.util.Date;

/**
 * User实体类
 * @author lishuai
 * 绑定表名
 */
@Data
@TableName(value = "user")
public class User {
    /**
     * 绑定主键
     */
    @TableId(value = "id")
    private int id;
    /**
     * 绑定属性
     */
    @TableField(value = "name")
    private String name;
    /**
     * 数据库中存在，但不查询,但不查询
     */
    //@TableField(value = "age",select = false)
    private int age;
    /**
     * 枚举映射，数据库中的字段映射枚举对象
     */
    @TableField(value = "gender")
    private GenderEnum gender;
    /**
     * 数据库中不存在对应字段
     */
    @TableField(exist = false)
    private String address;

    /**
     * 自动填充时间，对应创建的处理器
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @TableField(value = "deleted")
    @TableLogic
    private int deleted;
}
