package cat.yoink.clientapi.component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClientComponent
{
    String name();
    int x() default 50;
    int y() default 50;
    int width() default 50;
    int height() default 50;
    boolean draggable() default true;
}
