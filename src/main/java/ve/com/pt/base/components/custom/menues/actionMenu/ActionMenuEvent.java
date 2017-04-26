package ve.com.pt.base.components.custom.menues.actionMenu;

/**
 * ActionMenuEvent:
 *
 * Creado por bpena el 21/04/2017.
 */
public class ActionMenuEvent {
    private ActionMenuAction action;

    public ActionMenuEvent(ActionMenuAction action) {
        this.action = action;
    }

    public ActionMenuAction getAction() {
        return action;
    }

    public void setAction(ActionMenuAction action) {
        this.action = action;
    }
}
