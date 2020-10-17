package cat.yoink.clientapi.module;

import org.lwjgl.input.Keyboard;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClientModule
{
    String name();
    Category category();
    String description() default "Descriptionless";
    int bind() default Keyboard.KEY_NONE;
    boolean visible() default true;
}
