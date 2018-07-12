package com.xhwl.annotation;

import java.lang.annotation.*;

/**
 * @author zhengss
 *
 */

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SystemLog {
    String module()  default "";
    String methods()  default "";
}