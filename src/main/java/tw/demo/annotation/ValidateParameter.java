package tw.demo.annotation;

import java.lang.annotation.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: 自定义注解校验字段非空
 * @author: baixiaobai
 * @className: ValidateParameter
 * @Date: 2019/7/9
 * @Time: 下午4:46
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateParameter {

    /**
     * 分组class
     */
    public Class<?>[] groups() default {};

    /**
     * 长度判断(默认为0)
     */
    public int maxLen() default 0;

    /**
     * 最小长度检查,默认为0时不检查
     */
    public int minLen() default 0;

    /**
     * 正则匹配
     */
    public String reg() default "";

    String value() default "";
}