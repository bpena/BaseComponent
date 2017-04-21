package ve.com.pt.base.components.breadcrumb;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.themes.ValoTheme;
import ve.com.pt.MyUI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bpena on 4/21/17.
 */
public class Breadcrumb extends HorizontalLayout {
    private static final String SEPARATOR = ">";
    private EventBus bus;
    private List<BreadcrumbItem> itemList;

    public Breadcrumb() {
        this.bus = (EventBus) UI.getCurrent().getSession().getAttribute(MyUI.BUS_NAME);
        this.bus.register(this);

        this.itemList = new ArrayList<>();

        this.addStyleName("breadcrumb");
    }

    @Subscribe
    private void EventHandler(BreadcrumbEvent event) {
        try {
            switch (event.getAction()) {
                case ADD_ITEM:
                        this.addItem(event.getItem());
                    break;
                case REMOVE_ITEM:
                    break;
                case CLEAN:
                    this.clean();
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addItem(BreadcrumbItem item) throws Exception {
        if (item == null)
            throw new BreadcrumbException("No Item is defined");

        Boolean itemExist = this.itemList
                .stream()
                .map(BreadcrumbItem::getLabel)
                .anyMatch(item.getLabel()::equals);

        if (!itemExist) {
            item.setPos(this.itemList.size());
            this.itemList.add(item);
            this.updateView();
        }
    }

    private void removeItem(BreadcrumbItem item) {

    }

    private void clean() {
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
