package com.lishuai.common.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * 数据库性别映射
 * @author lishuai
 */

public enum GenderEnum {

    MAN(1,"男"),
    WOMAN(0,"女");

    /**
     * 枚举映射的键
     */
    @EnumValue
    private int code;
    private String gender;

    GenderEnum(int code,String gender){
        this.code=code;
        this.gender=gender;
    }
}
