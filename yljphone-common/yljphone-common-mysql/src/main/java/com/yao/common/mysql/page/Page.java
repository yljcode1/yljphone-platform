package com.yao.common.mysql.page;

import lombok.Data;

import java.io.Serializable;

/**
 * @date: 2022/7/9
 * @author: yao
 */
@Data
public class Page implements Serializable {
    private Integer pageNum;
    private Integer pageSize;
    private Integer pageCount;
    private Integer pageTotal;
}
