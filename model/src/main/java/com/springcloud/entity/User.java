package com.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体类
 * @author zhanghang
 * @date 2018/3/24
 */
@Data
public class User implements Serializable{
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
}
