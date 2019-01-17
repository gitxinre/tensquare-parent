package com.xinre.common.entity;

import lombok.Data;

import java.util.List;

/**
 * 分页结果
 *
 * @param <T>
 * @author xinre
 * @date 2019/1/16 16:39
 */
@Data
public class PageResult<T> {

    private Long total;
    private List<T> rows;

}
