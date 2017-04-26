package ve.com.pt.base.core.views.containerViews;

import com.google.common.eventbus.Subscribe;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import org.reflections.Reflections;
import ve.com.pt.base.components.custom.menues.actionMenu.ActionMenu;
import ve.com.pt.base.core.annotations.Funtionallity;
import ve.com.pt.base.core.annotations.Navigation;
import ve.com.pt.base.core.annotations.ViewAnnotation;
import ve.com.pt.base.core.views.ViewUI;
import ve.com.pt.base.core.views.navigator.BaseNavigator;

import java.lang.annotation.Annotation;
import java.util.Set;

/**
 * BaseContainerUI:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public class BaseContainerUI extends VerticalLayout implements View {
    protected ActionMenu actionMenu;
    protected CssLayout container;
    protected BaseNavigator baseNavigator;
    private String principalView;
    private Boolean viewsInitialized;

    public BaseContainerUI() {
        viewsInitialized = false;
        buildActionMenu();
        buildContainer();
        buildNavigator();
        registerViews();
    }

    protected void registerViews() {
        Navigation navigation = this.getClass().getAnnotation(Navigation.class);
        if (navigation != null) {
            for (ve.com.pt.base.core.annotations.View view : navigation.views()) {
                try {
                    registerView(view.uri(), (ViewUI) view.target().newInstance());
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
//        String myPackage = this.getClass().getPackage().getName();
//        Set<Class<?>> reflections = new Reflections(myPackage).getTypesAnnotatedWith(ViewAnnotation.class);
//        reflections
//                .stream()
//                .filter(aClass -> {
//                    Annotation annotation = aClass.getAnnotation(ViewAnnotation.class);
//                    if (annotation != null && annotation instanceof ViewAnnotation) {
//                        for (String target : ((ViewAnnotation) annotation).targets())
//                            if (target.equals(this.getClass().getAnnotation(Funtionallity.class).name()))
//                                return true;
//                    }
//                    return false;
//                })
//                .forEach(aClass -> {
//                    try {
//                        registerView(aClass.getAnnotation(ViewAnnotation.class).uri(), (ViewUI) aClass.newInstance());
//                        System.out.println(aClass.getName());
//                    } catch (InstantiationException e) {
//                        e.printStackTrace();
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//                });
    }

    protected void buildActionMenu() {
        actionMenu = new ActionMenu();
        actionMenu.setWidth(100, Unit.PERCENTAGE);
        this.addComponent(actionMenu);
    }

    protected void buildContainer() {
        container = new CssLayout();
        this.addComponent(container);
        this.setExpandRatio(container, 1);
    }

    protected void buildNavigator() {
        baseNavigator = new BaseNavigator(container);
    }

    protected void registerView(String viewName, ViewUI view) {
        baseNavigator.addView(viewName, view);
    }

    protected void setPrincipalView(String viewName) {
        this.principalView = viewName;
    }

    private void goToPrincipalView() {
        if (principalView != null)
            baseNavigator.navigateTo(principalView);
    }

    @Subscribe
    protected void goToView(BaseContainerEventNavigate event) {
        baseNavigator.navigateTo(event.getView());
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        if (viewChangeEvent.getParameters().isEmpty()) {
            // navegar a la vista principal
            this.goToPrincipalView();
        }
        else {
            baseNavigator.navigateTo(viewChangeEvent.getParameters());
        }
    }
}
