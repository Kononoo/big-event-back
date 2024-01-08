package com.ronan.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;
import org.apache.ibatis.annotations.Update;

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
    @NotNull(groups = Update.class)
    private Integer id;//主键ID

    @NotEmpty   // (groups = {Add.class, Update.class})
    private String categoryName; //分类名称

    @NotEmpty   // (groups = {Add.class, Update.class})
    private String categoryAlias; //分类别名

    private Integer createUser; //创建人ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createTime; //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateTime; //更新时间

    /**
     * 对参数进行分组校验 (validation的功能)
     */
    public interface Add extends Default {}
    public interface Update extends Default {}
}
