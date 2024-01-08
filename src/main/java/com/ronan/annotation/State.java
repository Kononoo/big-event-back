package com.ronan.annotation;

import com.ronan.validation.StateValidation;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * ClassName: State
 * Package: com.ronan.annotation
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 20:16
 * @Version: v1.0
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {StateValidation.class})   // 提供校验规则的类
public @interface State {
    //提供校验失败后的提示信息
    String message() default "state参数的值只能是已发布或者草稿";
    //指定分组
    Class<?>[] groups() default {};
    //负载  获取到State注解的附加信息
    Class<? extends Payload>[] payload() default {};
}
