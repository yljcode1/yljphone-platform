package com.yao.common.mysql.plugin;

import com.yao.common.mysql.page.Page;
import com.yao.common.mysql.page.PageThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.springframework.web.bind.ServletRequestUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 自定义Mybatis分页插件
 *
 * @date: 2022/7/9
 * @author: yao
 */
@Intercepts(
        @Signature(
                type = StatementHandler.class,
                method = "prepare",
                args = {Connection.class, Integer.class}
        )
)
@Slf4j
public class PagePlugin implements Interceptor {
    /**
     * 拦截的是Mybatis的Statement准备的方法
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 获取到StatementHandler
        StatementHandler statement = (StatementHandler) invocation.getTarget();
        // 获取截取的SQL语句
        String sql = statement.getBoundSql().getSql().toLowerCase().replace("\n", "");

        // 判断当前是否是查询语句的sql
        if (!sql.startsWith("select")) {
            // 非查询语句
            // 直接放行
            return invocation.proceed();
        }
        // 当前是select语句
        // 根据当前请求上下文，获取Page分页对象，如果能够获取到，说明需要分页，如果不能获取，说明无需分页
        // ThreadLocal 线程隔离
        Page page = PageThreadLocal.getPage();
        if (null == page) {
            // 未获取到分页对象
            return invocation.proceed();
        }
        // 分页对象
        log.info("[page - plugin]开始分页-{}", sql);
        Integer count = getCount(sql, invocation);
        return null;
    }

    /**
     * 计算查询的总条数
     */
    private Integer getCount(String sql, Invocation invocation) throws SQLException {
        String countSql = "select count(1) " + sql.substring(sql.indexOf("from"));
        log.info("[page - plugin] 生成分页总条数的sql语句 -{}", countSql);
        Connection connection = (Connection) invocation.getArgs()[0];
        try {
            // 设置相关SQL参数

            PreparedStatement ps = connection.prepareStatement(countSql);
            ps.execute();
        } catch (Exception e) {
            throw e;
        }
        return 0;
    }
}
