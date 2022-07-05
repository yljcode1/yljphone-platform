package com.yao.data.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 学生表(Student)表实体类
 *
 * @author makejava
 * @since 2022-07-05 20:53:01
 */
@Data
@Accessors(chain = true)
public class Student {
    //主键
    private Long id;
    //姓名
    private String name;
    //年龄
    private Integer age;
    //邮箱
    private String email;
    //生日
    private Date brithday;
    //性别o-男1-女
    private Integer sex;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //状态
    private Integer status;
    //删除标志0-可用1-删除
    private Integer delFlag;
}