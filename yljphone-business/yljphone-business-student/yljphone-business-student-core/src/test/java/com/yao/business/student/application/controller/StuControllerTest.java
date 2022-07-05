package com.yao.business.student.application.controller;

import com.yao.business.student.application.StuApplication;
import com.yao.data.entity.Student;
import com.yao.data.mapper.StudentDao;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StuApplication.class)
class StuControllerTest {

    @Autowired
    private StuController stuController;


    @Test
    void list() {
        stuController.list();
    }

    @Test
    void login() {
        stuController.login("zhangsan", "lisi");
    }

    /**
     * mybatis原始
     *
     * @throws IOException
     */
    @Test
    public void testMybatis() throws IOException {
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory build = builder.build(Resources.getResourceAsReader("mybatisl-config.xml"));
        SqlSession sqlSession = build.openSession();
        StudentDao mapper = sqlSession.getMapper(StudentDao.class);
        Student student = mapper.selectById(1);
        log.info("{}", student);
        sqlSession.commit();
        sqlSession.close();
    }
}