package com.yao.juc.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.concurrent.CompletableFuture;

/**
 * 链式编程
 * Accessors
 *
 * @date: 2022/8/15
 * @author: yao
 */
public class CompletableFutureAccessorsAndJoinDemo {
    public static void main(String[] args) {
        Student student = new Student();
        student.setStudentName("li4").setId(12).setMajor("English");
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return "hello";
        });
        // get 编译时报错
//        stringCompletableFuture.get();
        // join编译时不报错
        stringCompletableFuture.join();
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
