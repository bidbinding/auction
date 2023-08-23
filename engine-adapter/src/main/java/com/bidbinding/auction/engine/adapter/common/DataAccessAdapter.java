package com.bidbinding.auction.engine.adapter.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.lang.annotation.*;

@Documented
@Repository // TODO mfguven : Why is this annotation class marked as repository
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataAccessAdapter {

    @AliasFor(annotation = Component.class)
    String value() default "";

}
