package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 函数解释注解  如果没有设置 default 则使用注解时必须传入该值
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface MethodExplain {
    String title();    //函数名字
    String author() default ""; // 创作者
    String[] params() default {};  //参数
    String date() default "";   //创建日期
    String explain() default "";  // 函数解释
}
