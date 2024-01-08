package com.ronan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: CategoryService
 * Package: com.ronan.entity
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 14:48
 * @Version: v1.0
 */
@Data
public class Category {
    private Integer id;//主键ID
    @NotEmpty
    private String categoryName; //分类名称
    @NotEmpty
    private String categoryAlias; //分类别名
    private Integer createUser; //创建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime; //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime; //更新时间
}
