package ve.com.pt.base.components.custom.breadcrumb.events;

import ve.com.pt.base.components.custom.breadcrumb.BreadcrumbAction;

/**
 * BreadcrumbEventClean:
 * Evento para notificar que se eliminan todos los items del breadcrumb.
 *
 * Created by bpena on 4/21/17.
 */
public class BreadcrumbEventClean extends AbstractBreadcrumbEvent {
    public BreadcrumbEventClean() {
        super(BreadcrumbAction.CLEAN);
    }
}
