package ve.com.pt.base.components.custom.breadcrumb;

/**
 * Created by bpena on 4/21/17.
 */
public class BreadcrumbItem {
    private String label;
    private String action;
    private int pos;

    public BreadcrumbItem(String label) {
        this.label = label;
    }

    public BreadcrumbItem(String label, String action) {
        this(label);
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public BreadcrumbItem setLabel(String label) {
        this.label = label;
        return this;
    }

    public String getAction() {
        return action;
    }

    public BreadcrumbItem setAction(String action) {
        this.action = action;
        return this;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
