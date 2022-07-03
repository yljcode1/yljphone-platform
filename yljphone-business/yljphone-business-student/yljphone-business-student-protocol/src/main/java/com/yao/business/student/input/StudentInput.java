package com.yao.business.student.input;

import lombok.Data;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Format;

import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @date: 2022/7/3
 * @author: yao
 */
@Data
public class StudentInput implements Serializable {
    /**
     * 姓名
     */
    @NotBlank(message = "学生姓名不能为空！")
    private String name;
    /**
     * 年龄
     */
    @Max(value = 20, message = "年龄不能超过20岁")
    @NotNull(message = "年龄不能为空")
    private Integer age;
    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String email;
    /**
     * 生日
     */
    @Past(message = "生日范围不正确")
    @Format(formats = "yyyy-MM-dd HH:mm:ss")
    @NotNull(message = "生日不能为空")
    private LocalDateTime birthday;
    /**
     * 性别
     */
    @NotNull(message = "性别不能为空!")
    private Integer sex;
}
