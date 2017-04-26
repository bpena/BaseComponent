package ve.com.pt;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.spring.annotation.EnableVaadin;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ContextLoaderListener;
import ve.com.pt.base.components.custom.breadcrumb.Breadcrumb;
import ve.com.pt.base.components.custom.breadcrumb.BreadcrumbItem;
import ve.com.pt.base.components.custom.breadcrumb.events.BreadcrumbEventAdd;
import ve.com.pt.base.components.custom.breadcrumb.events.BreadcrumbEventClean;
import ve.com.pt.base.core.views.main.MainUI;
import ve.com.pt.base.core.views.navigator.events.NavigatorEventAdd;
import ve.com.pt.base.core.views.navigator.events.NavigatorEventNavigate;
import ve.com.pt.base.eventBus.DemoEvent;
import ve.com.pt.demo.CardContainerUI;
import ve.com.pt.demo.ProductContainerUI;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;

@Theme("mytheme")
@SpringUI
public class MyUI extends MainUI {
    private Breadcrumb breadcrumb;
    private Integer counter = 0;

    @WebListener
    public static class MyContextLoaderListener extends ContextLoaderListener {

    }

    @Configuration
    @EnableVaadin
    public static class MyConfiguration {

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    public static class MyUIServlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        super.init(vaadinRequest);
        bus.post(new NavigatorEventNavigate("producto"));
    }

    @Override
    protected void buildHeader() {
        super.buildHeader();

        Button button = new Button("Producto");
        button.addClickListener( e -> {
            System.out.println("lanzando evento");
            bus.post(new DemoEvent("nano"));
            bus.post(new BreadcrumbEventClean());
            bus.post(new BreadcrumbEventAdd(new BreadcrumbItem("producto".concat(counter.toString()), "producto".concat(counter.toString()))));
            bus.post(new NavigatorEventNavigate("producto"));
            counter++;
        });

        Button button2 = new Button("Tarjeta");
        button2.addClickListener( e -> {
            bus.post(new NavigatorEventNavigate("tarjeta"));
            bus.post(new BreadcrumbEventClean());
            bus.post(new BreadcrumbEventAdd(new BreadcrumbItem("tarjeta".concat(counter.toString()), "producto".concat(counter.toString()))));
            counter = 0;
        });

        header.addComponents(button, button2);
    }

    @Override
    protected void buildSubHeader() {
        super.buildSubHeader();
        breadcrumb = new Breadcrumb();
        subHeader.addComponent(breadcrumb);
        subHeader.setExpandRatio(breadcrumb, 1);
    }

    @Override
    protected void setViews() {
        super.setViews();
        bus.post(new NavigatorEventAdd("producto", ProductContainerUI.class));
        bus.post(new NavigatorEventAdd("tarjeta", CardContainerUI.class));
    }
}
