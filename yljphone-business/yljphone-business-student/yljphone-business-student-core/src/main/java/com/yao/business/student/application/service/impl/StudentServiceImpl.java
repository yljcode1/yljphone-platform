package com.yao.business.student.application.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yao.business.student.application.service.StudentService;
import com.yao.data.entity.Student;
import com.yao.data.mapper.StudentDao;
import org.springframework.stereotype.Service;

/**
 * 学生表(Student)表服务实现类
 *
 * @author makejava
 * @since 2022-07-05 20:53:02
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentDao, Student> implements StudentService {

}

