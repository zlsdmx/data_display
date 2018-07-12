package com.xhwl.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) 
@Target(ElementType.METHOD) 
@Documented 
@Inherited
public @interface  Auth {
	/**
	 * 是否验证用户登陆 true=验证 ,false = 不验证
	 * @return
	 */
	 public boolean checkUserLogin() default false;
	 
	 
	 /**
	 * 是否验证管理员登陆 true=验证 ,false = 不验证
	 * @return
	 */
	 public boolean checkAdminLogin() default false;
	 
	 
}
