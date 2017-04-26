package ve.com.pt.demo;

import com.vaadin.ui.Label;
import ve.com.pt.base.core.annotations.ViewAnnotation;
import ve.com.pt.base.core.views.ViewUI;

/**
 * CardListView:
 * <p>
 * Creado por bpena el 23/04/2017.
 */
public class CardListView extends ViewUI {
    public CardListView() {
        addComponent(new Label("CardListView"));
    }
}
