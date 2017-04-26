package ve.com.pt.base.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

/**
 * ViewAnnotation:
 * <p>
 * Creado por bpena el 25/04/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ViewAnnotation {
    String name() default "";
    String[] targets() default "";
    String uri() default "";
}
