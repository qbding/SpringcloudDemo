package com.dqb.cloud_common.config;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.TYPE})
public @interface NeiApi {

    int status() default 503;
}
