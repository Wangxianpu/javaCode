package src.com.wxp.annotationTest.annotation;//: net/mindview/atunit/TestObjectCreate.java
// The @Unit @TestObjectCreate tag.
import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TestObjectCreate {} ///:~
