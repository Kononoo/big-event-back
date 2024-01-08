package com.ronan.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * ClassName: PageBean
 * Package: com.ronan.entity
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 20:12
 * @Version: v1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageBean<T> {
    private Long total;  // 总记录数
    private List<T> items;  // 当前页记录数
}
