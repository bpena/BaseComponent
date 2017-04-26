package ve.com.pt.base.core.views;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.UI;
import ve.com.pt.base.core.views.main.MainUIConstants;

/**
 * ViewUI:
 *
 * Creado por bpena el 20/04/2017.
 */
public abstract class ViewUI extends BaseUI {
    private ViewMode mode;

    public ViewUI() {
        this.mode = ViewMode.BROWSE;
    }

    public ViewMode getMode() {
        return mode;
    }

    public void setMode(ViewMode mode) {
        this.mode = mode;
    }

    protected void updateView() {

    }

    @Override
    protected void setReadOnly(boolean readOnly) {
        super.setReadOnly(readOnly);
    }

    public void enter() {
        EventBus bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);
        bus.register(this);
    }

    @Subscribe
    public void launchAction(ActionEvent event) {
        System.out.println(event.getAction());
    }
}
