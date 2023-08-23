package com.bidbinding.auction.engine.adapter.common;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

import java.util.Set;

import static jakarta.validation.Validation.buildDefaultValidatorFactory;

//TODO mfguven : Not sure about this class. No spring annotations.
public class Validator {

    private final static jakarta.validation.Validator validator = buildDefaultValidatorFactory().getValidator();

    public static <T> void validate(T subject) {
        Set<ConstraintViolation<T>> violations = validator.validate(subject);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
