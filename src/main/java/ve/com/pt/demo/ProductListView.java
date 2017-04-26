package ve.com.pt.demo;

import com.vaadin.ui.Label;
import ve.com.pt.base.core.annotations.ViewAnnotation;
import ve.com.pt.base.core.views.ViewUI;

/**
 * ProductListView:
 * <p>
 * Creado por bpena el 23/04/2017.
 */
public class ProductListView extends ViewUI {
    public ProductListView() {
        addComponent(new Label("ProductListView"));
    }
}
