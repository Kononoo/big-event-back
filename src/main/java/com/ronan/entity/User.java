package com.ronan.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * ClassName: User
 * Package: com.ronan.entity
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 14:48
 * @Version: v1.0
 */
@Data
public class User {
	@NotNull
	private Integer id;//主键ID
	private String username;//用户名

	@JsonIgnore  // 让springmvc转为json对象时忽略password字段
	private String password;//密码

	@NotEmpty
	@Pattern(regexp = "^\\S{1,15}$")
	private String nickname;//昵称

	@NotEmpty
	@Email
	private String email;//邮箱
	private String userPic;//用户头像地址
	private LocalDateTime createTime;//创建时间
	private LocalDateTime updateTime;//更新时间
}
