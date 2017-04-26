package ve.com.pt.base.core.annotations;

import ve.com.pt.base.core.views.ViewMode;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * View:
 * <p>
 * Creado por bpena el 25/04/2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface View {
    String name() default "";
    String uri() default "";
    Class target();
    ViewMode mode() default ViewMode.BROWSE;
}
