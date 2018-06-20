package Study.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface MyFirstAnnotation {
    String color() default "lalal";
    String value();
    int[] arrayAttr() default {1, 2, 3};
    MyColorEnum retEnum() default MyColorEnum.BLUE;
    MySecAnnotation retAnno() default @MySecAnnotation("zhangsan");
}
