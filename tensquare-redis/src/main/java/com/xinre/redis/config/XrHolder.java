package com.xinre.redis.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 处理程序，接收闭包内变量使用
 *
 * @author xinre
 * @date 2019/2/1 16:35
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class XrHolder<T> {
    private T value;
}
