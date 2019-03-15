package com.kdwl.core.include.page;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface WhereType {
    WhereTypeEnum type() default WhereTypeEnum.EQ;

    boolean ignore() default false;

    boolean andNew() default  false;
}

