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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StuApplication.class)
class StuControllerTest {

    @Autowired
    private StuController stuController;


//    @Test
//    void list() {
//        stuController.list();
//    }

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

    @Test
    public void testJDBC() throws SQLException {
        String sql = "select * from xxxx";
        // 获得数据库连接
        Connection connection = null;
        //通过连接获取到statement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        // 通过statement对象设置参数
        preparedStatement.setInt(1, 10);

        // 执行sql语句
        preparedStatement.execute();
        // 获取到查询的结果
        ResultSet resultSet = preparedStatement.getResultSet();
        while (resultSet.next()) {

        }

    }
}