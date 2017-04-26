package ve.com.pt.base.core.views.main;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.*;
import ve.com.pt.base.core.views.navigator.events.NavigatorEventAdd;
import ve.com.pt.base.core.views.navigator.events.NavigatorEventNavigate;

import static ve.com.pt.base.core.views.main.MainUIConstants.BUS_NAME;

/**
 * MainUI:
 * De aca se extendera para generar clases de tipo ventana principal.
 * De forma predeterminada esto contendra un Header, un SubHeader, un Container,
 *   un Footer y se asociara un BaseNavigator el container para que realice la carga
 *   de las vistas y los cambios entre estas.
 *
 * Creado por bpena el 21/04/2017.
 */
public class MainUI extends UI implements View {
    protected VerticalLayout mainContainer;
    protected HorizontalLayout header;
    protected HorizontalLayout subHeader;
    protected VerticalLayout container;
    protected HorizontalLayout footer;
    protected Navigator navigator;
    protected EventBus bus;

    public MainUI() {
        mainContainer = new VerticalLayout();
        mainContainer.setSizeFull();
        mainContainer.setMargin(false);
        mainContainer.setSpacing(false);
        setContent(mainContainer);
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        registerEventBus();

        buildHeader();
        buildSubHeader();
        buildContainer();
        buildFooter();

        setNavigator();
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {

    }

    /**
     * registerEventBus:
     * Crea y configura el bus de eventos principal y lo deja disponible para
     * utilizarlo en toda la aplicacion al compartirlo en la sesion de vaadin.
     */
    protected void registerEventBus() {
        bus = new EventBus();
        bus.register(this);
        UI.getCurrent().getSession().setAttribute(BUS_NAME, bus);
    }

    /**
     * buildHeader:
     * Construye y agrega el encabezado
     */
    protected void buildHeader() {
        header = new HorizontalLayout();
        header.setWidth(100, Unit.PERCENTAGE);
        header.setSpacing(false);
        header.addComponent(new Label("Header"));
        mainContainer.addComponent(header);
    }

    /**
     * setVisibleHeader:
     * Configura la visibilidad del encabezado.
     * @param visible: valor de la visibilidad.
     */
    protected void setVisibleHeader(Boolean visible) {
        header.setVisible(visible);
    }

    /**
     * buildSubHeader:
     * Construye y agrega el encabezado secundario
     */
    protected void buildSubHeader() {
        subHeader = new HorizontalLayout();
        subHeader.setWidth(100, Unit.PERCENTAGE);
        subHeader.setSpacing(false);
        subHeader.addComponent(new Label("sub header"));
        mainContainer.addComponent(subHeader);
    }

    /**
     * Configura la visibilidad del encabezado secundario.
     * @param visible: valor de la visibilidad del encabezado.
     */
    protected void setVisibleSubHeader(Boolean visible) {
        subHeader.setVisible(visible);
    }

    /**
     * buildContainer
     * Construye y agrega la seccion de navegacion o contenedor principal
     */
    protected void buildContainer() {
        container = new VerticalLayout();
        mainContainer.addComponent(container);
        mainContainer.setExpandRatio(container, 1);
    }

    /**
     * buildFooter
     * Construye y agrega el Footer
     */
    protected void buildFooter() {
        footer = new HorizontalLayout();
        footer.addComponent(new Label("footer"));
        mainContainer.addComponent(footer);
    }

    /**
     * setVisibleFooter:
     * Configura la visibilidad de Footer.
     * @param visible: valor de la visibilidad el footer.
     */
    protected void setVisibleFooter(Boolean visible) {
        footer.setVisible(visible);
    }

    /**
     * setNavigator
     * Se crea y se configura el BaseNavigator
     */
    protected void setNavigator() {
        navigator = new Navigator(this, container);
        setViews();
        setErrorViews();
    }

    /**
     * setViews:
     * Configura y agrega el listado de vistas o clases en el baseNavigator.
     */
    protected void setViews() {

    }

    /**
     * setErrorViews:
     * Para configurar las vistas para error.
     */
    protected void setErrorViews() {

    }

    protected void updateView() {

    }

    @Subscribe
    protected void updateNavigator(NavigatorEventAdd event) {
        UI.getCurrent().getNavigator().addView(event.getTarget(), event.getClazz());
    }

    @Subscribe
    protected void navigateTo(NavigatorEventNavigate event) {
        UI.getCurrent().getNavigator().navigateTo(event.getTarget());
    }
}
