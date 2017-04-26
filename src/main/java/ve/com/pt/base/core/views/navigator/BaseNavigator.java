package ve.com.pt.base.core.views.navigator;

import com.vaadin.ui.*;
import com.vaadin.ui.Component;
import ve.com.pt.base.core.views.ViewUI;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * BaseNavigator:
 * <p>
 * Creado por bpena el 23/04/2017.
 */
public class BaseNavigator {
    private Map<String, ? super ViewUI> views;
    private Layout componetContainer;

    public BaseNavigator(Layout componetContainer) {
        if (componetContainer == null)
            throw new RuntimeException("componentContainer is mandatory");
        this.views = new HashMap<>();
        this.componetContainer = componetContainer;
    }

    public Layout getComponetContainer() {
        return componetContainer;
    }

    public void addView(String viewName, ViewUI view) {
        if (viewName == null || viewName.isEmpty())
            throw new RuntimeException("No name is provided for baseNavigator view");

        if (view == null)
            throw new RuntimeException("No view is provided for baseNavigator");

        views.put(viewName, view);
    }

    public void navigateTo(String viewName) {
        if (viewName == null || viewName.isEmpty())
            throw new RuntimeException("No view name has been defined");

        if (views.get(viewName) != null) {
            componetContainer.removeAllComponents();
            componetContainer.addComponent((Component) views.get(viewName));
            ((ViewUI) views.get(viewName)).enter();
        }
    }
}
