package ve.com.pt.base.core.views.navigator.events;

import ve.com.pt.base.core.views.navigator.NavigatorAction;

/**
 * AbstractNavigatorEvent:
 * <p>
 * Creado por bpena el 22/04/2017.
 */
public abstract class AbstractNavigatorEvent {
    private NavigatorAction action;
    private String target;

    public AbstractNavigatorEvent(NavigatorAction action, String target) {
        this.action = action;

        if (target == null || target.isEmpty())
            throw new RuntimeException("");

        this.target = target;
    }

    public NavigatorAction getAction() {
        return action;
    }

    public AbstractNavigatorEvent setAction(NavigatorAction action) {
        this.action = action;
        return this;
    }

    public String getTarget() {
        return target;
    }

    public AbstractNavigatorEvent setTarget(String target) {
        this.target = target;
        return this;
    }
}
