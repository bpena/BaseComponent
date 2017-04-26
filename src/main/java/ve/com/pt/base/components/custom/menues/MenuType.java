package ve.com.pt.base.components.custom.menues;

/**
 * MenuType:
 * <p>
 * Creado por bpena el 26/04/2017.
 */
public enum MenuType {
    ACTION,
    NAVIGATION;

    public Boolean equals(MenuType menuType) {
        return this.name().equals(menuType.name());
    }

    public Boolean equals(String menuType) {
        return this.name().equals(menuType.toUpperCase());
    }
}
