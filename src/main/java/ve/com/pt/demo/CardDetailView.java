package ve.com.pt.demo;

import com.vaadin.ui.Label;
import ve.com.pt.base.core.annotations.ViewAnnotation;
import ve.com.pt.base.core.views.ViewUI;

/**
 * CardDetailView:
 * <p>
 * Creado por bpena el 23/04/2017.
 */
public class CardDetailView extends ViewUI {
    public CardDetailView() {
        addComponent(new Label("CardDetailView"));
    }
}
