package ve.com.pt.base.components.custom.menues;

import com.vaadin.icons.VaadinIcons;
import ve.com.pt.base.core.views.ViewMode;

/**
 * BaseMenuItem:
 * <p>
 * Creado por bpena el 24/04/2017.
 */
public class BaseMenuItem {
    private String caption;
    private VaadinIcons uriIcon;
    private String uriApp;
    private ViewMode viewMode;
    private MenuType menuType;

    public BaseMenuItem() {
        this.menuType = MenuType.NAVIGATION;
    }

    public String getCaption() {
        return caption;
    }

    public BaseMenuItem setCaption(String caption) {
        this.caption = caption;
        return this;
    }

    public VaadinIcons getUriIcon() {
        return uriIcon;
    }

    public BaseMenuItem setUriIcon(VaadinIcons uriIcon) {
        this.uriIcon = uriIcon;
        return this;
    }

    public String getUriApp() {
        return uriApp;
    }

    public BaseMenuItem setUriApp(String uriApp) {
        this.uriApp = uriApp;
        return this;
    }

    public ViewMode getViewMode() {
        return viewMode;
    }

    public BaseMenuItem setViewMode(ViewMode viewMode) {
        this.viewMode = viewMode;
        return this;
    }

    public BaseMenuItem setViewMode(String viewMode) {
        this.viewMode = ViewMode.valueOf(viewMode.toUpperCase());
        return this;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public BaseMenuItem setMenuType(MenuType menuType) {
        this.menuType = menuType;
        return this;
    }
}
