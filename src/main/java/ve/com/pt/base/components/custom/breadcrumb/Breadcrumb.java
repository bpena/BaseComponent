package ve.com.pt.base.components.custom.breadcrumb;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import ve.com.pt.MyUI;
import ve.com.pt.base.components.custom.breadcrumb.events.BreadcrumbEventAdd;
import ve.com.pt.base.components.custom.breadcrumb.events.BreadcrumbEventClean;
import ve.com.pt.base.core.views.main.MainUIConstants;

import java.util.ArrayList;
import java.util.List;

/**
 * Breaccrumb:
 *
 * Creado por bpena el 21/04/2017.
 */
public class Breadcrumb extends HorizontalLayout {
    private static final String SEPARATOR = ">";
    private EventBus bus;
    private List<BreadcrumbItem> itemList;

    public Breadcrumb() {
        this.bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);
        this.bus.register(this);

        this.itemList = new ArrayList<>();

        this.addStyleName("breadcrumb");
    }

    @Subscribe
    private void addItem(BreadcrumbEventAdd event) {
        Boolean itemExist = this.itemList
                .stream()
                .map(BreadcrumbItem::getLabel)
                .anyMatch(event.getItem().getLabel()::equals);

        if (!itemExist) {
            event.getItem().setPos(this.itemList.size());
            this.itemList.add(event.getItem());
            this.updateView();
        }
    }

    private void removeItem(BreadcrumbItem item) {

    }

    @Subscribe
    private void clean(BreadcrumbEventClean event) {
        this.itemList = new ArrayList<>();
        this.updateView();
    }

    private void updateView() {
        this.removeAllComponents();

        if (this.itemList.size() > 0) {
            this.itemList.subList(0, this.itemList.size() - 1)
                    .forEach(item -> {
                        Button breadcrumbItem = new Button();
                        breadcrumbItem.setCaption(item.getLabel());
                        breadcrumbItem.addStyleName(ValoTheme.BUTTON_LINK);
                        breadcrumbItem.addStyleName(ValoTheme.LABEL_BOLD);
                        breadcrumbItem.addClickListener(clickEvent -> onClickItem(item));
                        this.addComponent(breadcrumbItem);

                        Label separator = new Label(SEPARATOR);
                        this.addComponent(separator);
                    });

            Label label = new Label(this.itemList.get(this.itemList.size() - 1).getLabel());
            this.addComponent(label);
        }
    }

    private void onClickItem(BreadcrumbItem item) {
        this.itemList.removeIf(breadcrumbItem -> breadcrumbItem.getPos() > item.getPos());
        this.updateView();
    }
}
