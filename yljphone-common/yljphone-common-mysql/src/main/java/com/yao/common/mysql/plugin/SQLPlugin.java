package com.yao.common.mysql.plugin;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.ResultHandler;

import java.math.BigDecimal;
import java.sql.Statement;


/**
 * SQL监控记录插件
 *
 * @date: 2022/7/9
 * @author: yao
 */
@Intercepts(
        @Signature(
                type = StatementHandler.class,// 指定拦截器增强内置对象的类型
                method = "query",// 指定拦截器增强方法
                args = {Statement.class, ResultHandler.class}//方法
        )
)
@Slf4j
public class SQLPlugin implements Interceptor {

    /**
     * 核心拦截方法
     *
     * @param invocation
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        // 记录当前执行的sql语句 & 记录sql语句执行的耗时
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();// 获取到拦截到的目标对象
        String sql = statementHandler.getBoundSql().getSql();
        //记录到执行的sql
        log.info("[SQL-EXEC] 执行的sql语句:{}", sql);
        // 记录sql的执行耗时
        long begin =System.currentTimeMillis();
        // 执行sql-放行
        Object result = invocation.proceed();
        long end = System.currentTimeMillis();
        log.info("[SQL-EXEC] SQL 的耗时:{}s", BigDecimal.valueOf(end).subtract(BigDecimal.valueOf(begin)).divide(BigDecimal.valueOf(1000)).setScale(6,BigDecimal.ROUND_DOWN));
        return result;
    }
}
