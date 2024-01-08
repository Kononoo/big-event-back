package com.ronan.entity;

import com.ronan.annotation.State;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

/**
 * ClassName: Article
 * Package: com.ronan.entity
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 14:48
 * @Version: v1.0
 */
@Data
public class Article {
	private Integer id;//主键ID
	@NotEmpty
	@Pattern(regexp = "^\\S{1,20}$")
	private String title;//文章标题
	@NotEmpty
	private String content;//文章内容

	@URL
	@NotEmpty
	private String coverImg;//封面图像
	@State
	private String state;//发布状态 已发布|草稿
	@NotNull
	private Integer categoryId;//文章分类id
	private Integer createUser;//创建人ID
	private LocalDateTime createTime;//创建时间
	private LocalDateTime updateTime;//更新时间
}

