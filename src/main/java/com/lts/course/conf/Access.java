package com.lts.course.conf;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Access {

    /**
     * String
     * @return String
     */
    String[] authorities() default {};

    /**
     * String
     * @return String
     */
    String[] roles() default {};

    /**
     * String
     * @return String
     */
    String operation() default "";
}
