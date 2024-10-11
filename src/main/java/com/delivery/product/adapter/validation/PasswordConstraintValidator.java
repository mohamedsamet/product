package com.delivery.product.adapter.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import org.passay.*;


@Component
public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(ValidPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String pwd, ConstraintValidatorContext constraintValidatorContext) {

        /* BASIC VALIDATION PASSAY IS A LIBRARY TO CUSTOMIZE PASSWORD VALIDATION */
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(4, 127),
                new WhitespaceRule()
        ));

        RuleResult result = validator.validate(new PasswordData(pwd));
        if (result.isValid()) {
            return true;
        }

        constraintValidatorContext.disableDefaultConstraintViolation();
        constraintValidatorContext.buildConstraintViolationWithTemplate(
                        String.join(", ", validator.getMessages(result)))
                .addConstraintViolation();
        return false;
    }
}
