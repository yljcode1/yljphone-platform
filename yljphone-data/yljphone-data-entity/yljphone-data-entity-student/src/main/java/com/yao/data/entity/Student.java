package com.yao.data.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.yao.data.base.BaseEntity;
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
public class Student extends BaseEntity {
    //主键
    @TableId(type = IdType.AUTO)
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
}