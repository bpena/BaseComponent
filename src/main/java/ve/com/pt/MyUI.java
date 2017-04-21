package ve.com.pt;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

import com.google.common.eventbus.EventBus;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.server.SpringVaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import ve.com.pt.base.components.breadcrumb.Breadcrumb;
import ve.com.pt.base.components.breadcrumb.BreadcrumbAction;
import ve.com.pt.base.components.breadcrumb.BreadcrumbEvent;
import ve.com.pt.base.components.breadcrumb.BreadcrumbItem;
import ve.com.pt.base.eventBus.DemoEvent;
import ve.com.pt.demo.Demo;

@Theme("mytheme")
@SpringUI
public class MyUI extends UI {
    private EventBus bus;
    private Demo demo;
    private Breadcrumb breadcrumb;
    public static final String BUS_NAME = "EVENT_BUS";
    private Integer counter = 0;

    @WebListener
    public static class MyContextLoaderListener extends ContextLoaderListener {

    }

    @Configuration
    @EnableVaadin
    public static class MyConfiguration {

    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        registerEventBus();

        final VerticalLayout layout = new VerticalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener( e -> {
            System.out.println("lanzando evento");
            bus.post(new DemoEvent("nano"));
            bus.post(new BreadcrumbEvent(BreadcrumbAction.ADD_ITEM, new BreadcrumbItem("cargar".concat(counter.toString()), "cargar".concat(counter.toString()))));
            counter++;
        });

        Button button2 = new Button("Click Me");
        button2.addClickListener( e -> {
            bus.post(new BreadcrumbEvent(BreadcrumbAction.CLEAN));
            counter = 0;
        });

        demo = new Demo();
        breadcrumb = new Breadcrumb();
        layout.addComponents(name, breadcrumb, button, button2, demo);
        
        setContent(layout);


        demo.enter(null);
    }

    private void registerEventBus() {
        bus = new EventBus();
        bus.register(this);
        UI.getCurrent().getSession().setAttribute(BUS_NAME, bus);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    public static class MyUIServlet extends VaadinServlet {
    }
}
