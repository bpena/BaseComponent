package ve.com.pt.base.core.views;

/**
 * ViewMode:
 * <p>
 * Creado por bpena el 25/04/2017.
 */
public enum ViewMode {
    BROWSE,
    EDIT;

    public Boolean equals(String viewMode) {
        return this.name().equals(viewMode.toUpperCase());
    }

    public Boolean equals(ViewMode viewMode) {
        return this.name().equals(viewMode.name());
    }
}
