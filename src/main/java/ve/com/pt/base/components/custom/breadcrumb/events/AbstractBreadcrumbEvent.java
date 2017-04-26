package ve.com.pt.base.components.custom.breadcrumb.events;

import ve.com.pt.base.components.custom.breadcrumb.BreadcrumbAction;

/**
 * AbstractBreadcrumbEvent:
 * Evento base para la generacion de eventos del breadcrumb.
 *
 * Creado por bpena el 21/04/2017.
 */
public abstract class AbstractBreadcrumbEvent {
    protected BreadcrumbAction action;

    public AbstractBreadcrumbEvent(BreadcrumbAction action) {
        this.action = action;
    }

    public BreadcrumbAction getAction() {
        return action;
    }

    public void setAction(BreadcrumbAction action) {
        this.action = action;
    }
}
