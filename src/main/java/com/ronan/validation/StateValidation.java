package com.ronan.validation;

import com.ronan.annotation.State;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.validation.annotation.Validated;

/**
 * ClassName: StateValidation
 * Package: com.ronan.validation
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 20:40
 * @Version: v1.0
 */
public class StateValidation implements ConstraintValidator<State, String> {

    /**
     *
     * @param s 要校验的数据
     * @param constraintValidatorContext
     * @return 返回false不通过，true通过
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if (s == null) {
            return false;
        }
        if (s.equals("已发布") || s.equals("草稿")) {
            return true;
        }
        return false;
    }
}
