package ve.com.pt.base.core.views.containerViews;

import ve.com.pt.base.core.views.ViewUI;

/**
 * BaseContainerEventNavigate:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public class BaseContainerEventNavigate {
    private String view;

    public BaseContainerEventNavigate(String viewName) {
        if (viewName == null || viewName.isEmpty())
            throw new BaseContainerUIException("ViewName must be defined on BaseContainerEventNavigate");
        this.view = viewName;
    }

    public String getView() {
        return view;
    }

    public BaseContainerEventNavigate setView(String viewName) {
        this.view = viewName;
        return this;
    }
}
