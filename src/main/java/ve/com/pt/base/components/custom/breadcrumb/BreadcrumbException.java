package ve.com.pt.base.components.custom.breadcrumb;

/**
 * BreadcrumbException:
 *
 * Creado por bpena el 21/04/2017.
 */
public class BreadcrumbException extends RuntimeException {
    public BreadcrumbException() {
    }

    public BreadcrumbException(String message) {
        super(message);
    }

    public BreadcrumbException(String message, Throwable cause) {
        super(message, cause);
    }

    public BreadcrumbException(Throwable cause) {
        super(cause);
    }

    public BreadcrumbException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
