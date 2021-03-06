package src.com.wxp.annotationTest.annotation;//: annotations/database/SQLInteger.java
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SQLInteger {
    String name() default "";
    Constraints constraints() default @Constraints;
} ///:~
