package cat.yoink.clientapi.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClientCommand
{
    String name();
    String[] aliases();
    String usage() default "";
    String description() default "Descriptionless";
}
