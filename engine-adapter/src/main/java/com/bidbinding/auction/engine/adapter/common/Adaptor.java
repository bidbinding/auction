package com.bidbinding.auction.engine.adapter.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.lang.annotation.*;

@Documented
@Service // TODO mfguven : Why is this annotation class marked as service
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Adaptor {

    @AliasFor(annotation = Component.class)
    String value() default "";

}
