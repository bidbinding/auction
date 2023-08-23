package com.bidbinding.auction.engine.adapter.driver.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.math.BigDecimal;

public class MoneyValidator implements ConstraintValidator<Money, BigDecimal> {

    @Override
    public boolean isValid(BigDecimal amount, ConstraintValidatorContext constraintValidatorContext) {
        return amount != null && amount.signum() != -1;
    }
}
