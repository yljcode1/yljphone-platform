package com.yao.juc.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 链式编程
 * Accessors
 *
 * @date: 2022/8/15
 * @author: yao
 */
public class CompletableFutureMallDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setStudentName("li4").setId(12).setMajor("English");
    }
}

@NoArgsConstructor
@AllArgsConstructor
@Data
@Accessors(chain = true)
class Student {
    private Integer id;
    private String studentName;
    private String major;

}
