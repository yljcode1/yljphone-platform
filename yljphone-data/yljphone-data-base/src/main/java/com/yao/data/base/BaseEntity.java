package com.yao.data.base;

import java.io.Serializable;
import java.util.Date;

/**
 * @date: 2022/7/5
 * @author: yao
 */
public class BaseEntity implements Serializable {
    // 创建时间
    private Date createTime;
    // 修改时间
    private Date updateTime;
    // 状态
    private Integer status;
    // 删除标志 0-可用，1删除
    private Integer delFlag;
}
