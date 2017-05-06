package cn.blaze.utils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Token
 * @Description 防止表单重复提交的注解
 * 在需要生成token的controller上增加@Token(save=true)生成token值，
 * 而在需要检查重复提交的controller上添加@Token(remove=true)移除token值
 * @author LiuLei
 * @date 2017年5月5日 下午10:35:55
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {
	
	boolean save() default false;
	
	boolean remove() default false;
}
