package ve.com.pt.demo;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import ve.com.pt.MyUI;
import ve.com.pt.base.core.views.BaseUI;
import ve.com.pt.base.eventBus.DemoEvent;

/**
 * Created by bpena on 4/20/17.
 */
public class Demo extends BaseUI implements View {
    EventBus bus;

    public Demo() {
    }

    @Override
    protected boolean preSave() {
        this.addComponent(new Label("preSave"));
        return super.preSave();
    }

    @Override
    protected boolean actionSave() {
        this.addComponent(new Label("actionSave"));
        return super.actionSave();
    }

    @Override
    protected boolean postSave() {
        this.addComponent(new Label("postSave"));
        return super.postSave();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        this.bus = (EventBus) UI.getCurrent().getSession().getAttribute(MyUI.BUS_NAME);
        this.bus.register(this);
    }

    @Subscribe
    private void eventHandler(DemoEvent event) {
        System.out.println("escuchando evento");
        this.onSave();
    }
}
