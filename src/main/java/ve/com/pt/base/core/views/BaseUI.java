package ve.com.pt.base.core.views;

import com.vaadin.ui.CssLayout;
import ve.com.pt.base.core.annotations.Function;

/**
 * BaseUI:
 *
 * Creado por bpena el 20/04/2017.
 */
public abstract class BaseUI extends CssLayout {
    protected  boolean preNew() {
        return true;
    }

    protected void onNew() {
        if (this.preNew()) {
            this.actionNew();
            this.postNew();
        }

    }

    protected boolean actionNew() {
        return true;
    }

    protected boolean postNew() {
        return true;
    }

    protected boolean preEdit() {
        return true;
    }

    protected void onEdit() {
        if (this.preEdit()) {
            this.actionEdit();
            this.postEdit();
        }
    }

    protected boolean actionEdit() {
        return true;
    }

    protected boolean postEdit() {
        return true;
    }

    protected boolean preDelete() {
        return true;
    }

    protected void onDelete() {
        if (this.preDelete()) {
            this.deleteAction();
            this.postDelete();
        }
    }

    @Function(action = "delete")
    protected boolean deleteAction() {
        System.out.println("borrando");
        return true;
    }

    protected boolean postDelete() {
        return true;
    }

    protected boolean preCancel() {
        return true;
    }

    protected void onCancel() {
        if (this.preCancel()) {
            this.actionCancel();
            this.postCancel();
        }
    }

    protected boolean actionCancel() {
        return true;
    }

    protected boolean postCancel() {
        return true;
    }

    protected boolean preSave() {
        return true;
    }

    protected void onSave() {
        if (this.preSave() && this.validate()) {
            this.actionSave();
            this.postSave();
        }
    }

    protected boolean actionSave() {
        return true;
    }

    protected boolean postSave() {
        return true;
    }

    protected boolean validate() {
        return true;
    }
}
