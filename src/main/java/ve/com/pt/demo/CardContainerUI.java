package ve.com.pt.demo;

import ve.com.pt.base.components.custom.menues.BaseMenuItem;
import ve.com.pt.base.components.custom.menues.actionMenu.ActionMenuItem;
import ve.com.pt.base.core.annotations.Funtionallity;
import ve.com.pt.base.core.annotations.Navigation;
import ve.com.pt.base.core.annotations.View;
import ve.com.pt.base.core.views.ViewMode;
import ve.com.pt.base.core.views.containerViews.BaseContainerUI;

import java.util.ArrayList;
import java.util.List;

/**
 * CardContainerUI:
 * <p>
 * Creado por bpena el 23/04/2017.
 */
@Funtionallity(name = "Tarjeta")
@Navigation(
        views = {
                @View(uri = "create", target = ve.com.pt.demo.CardDetailView.class, mode = ViewMode.EDIT),
                @View(uri = "edit", target = CardDetailView.class, mode = ViewMode.EDIT),
                @View(uri = "detail", target = ve.com.pt.demo.CardDetailView.class),
                @View(uri = "list", target = ve.com.pt.demo.CardListView.class)
        }
)
//@Navigation
public class CardContainerUI extends BaseContainerUI{
    @Override
    protected void buildActionMenu() {
        super.buildActionMenu();

        List<BaseMenuItem> menuItems = new ArrayList<BaseMenuItem>();
        menuItems.add(new BaseMenuItem().setCaption("demo2").setUriApp("tarjeta/detail"));
        menuItems.add(new BaseMenuItem().setCaption("demo4").setUriApp("tarjeta/list"));

        actionMenu.setActionMenuItem(menuItems);
    }
}
