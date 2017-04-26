package ve.com.pt.base.components.custom.breadcrumb.events;

import ve.com.pt.base.components.custom.breadcrumb.BreadcrumbAction;
import ve.com.pt.base.components.custom.breadcrumb.BreadcrumbException;
import ve.com.pt.base.components.custom.breadcrumb.BreadcrumbItem;

/**
 * BreadcrumbEventAdd:
 * Evento para notificar la adicion de un nuevo item al breadcrumb.
 *
 * Creado por bpena el 21/04/2017.
 */
public class BreadcrumbEventAdd extends AbstractBreadcrumbEvent {
    protected BreadcrumbItem item;

    public BreadcrumbEventAdd(BreadcrumbItem item) {
        super(BreadcrumbAction.ADD_ITEM);

        if (item == null)
            throw new BreadcrumbException("No item is defined");

        this.item = item;
    }

    public BreadcrumbItem getItem() {
        return item;
    }

    public BreadcrumbEventAdd setItem(BreadcrumbItem item) {
        this.item = item;
        return this;
    }
}
