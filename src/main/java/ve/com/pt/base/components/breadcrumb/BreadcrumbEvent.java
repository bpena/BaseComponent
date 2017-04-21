package ve.com.pt.base.components.breadcrumb;

/**
 * Created by bpena on 4/21/17.
 */
public class BreadcrumbEvent {
    private BreadcrumbAction action;
    private BreadcrumbItem item;

    public BreadcrumbEvent(BreadcrumbAction action) {
        this.action = action;
    }

    public BreadcrumbEvent(BreadcrumbAction action, BreadcrumbItem item) {
        this(action);
        this.item = item;
    }

    public BreadcrumbAction getAction() {
        return action;
    }

    public BreadcrumbEvent setAction(BreadcrumbAction action) {
        this.action = action;
        return this;
    }

    public BreadcrumbItem getItem() {
        return item;
    }

    public BreadcrumbEvent setItem(BreadcrumbItem item) {
        this.item = item;
        return this;
    }
}
