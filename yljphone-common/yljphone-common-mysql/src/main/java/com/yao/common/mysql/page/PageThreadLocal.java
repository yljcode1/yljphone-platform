package com.yao.common.mysql.page;

/**
 * 分页工具类-ThreadLocal用来存储当前请求的Page对象
 *
 * @date: 2022/7/9
 * @author: yao
 */
public class PageThreadLocal {
    private static ThreadLocal<Page> pageThreadLocal = new ThreadLocal<>();

    /**
     * 设置分页信息
     */
    public void setPage(Integer pageNum, Integer pageSize) {
        Page page = new Page();
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        pageThreadLocal.set(page);
    }

    /**
     * 获取到分页信息
     *
     * @return 返回值
     */
    public static Page getPage() {
        return pageThreadLocal.get();
    }

    /**
     * 清空Page信息
     */
    public static void cleanThreadLocalPage() {
        pageThreadLocal.remove();
    }
}
