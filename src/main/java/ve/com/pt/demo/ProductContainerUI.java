package ve.com.pt.demo;

import com.google.common.eventbus.Subscribe;
import ve.com.pt.base.components.custom.menues.BaseMenuItem;
import ve.com.pt.base.components.custom.menues.MenuType;
import ve.com.pt.base.components.custom.menues.actionMenu.ActionMenuItem;
import ve.com.pt.base.core.annotations.Funtionallity;
import ve.com.pt.base.core.annotations.Navigation;
import ve.com.pt.base.core.annotations.View;
import ve.com.pt.base.core.views.ActionEvent;
import ve.com.pt.base.core.views.ViewMode;
import ve.com.pt.base.core.views.containerViews.BaseContainerUI;

import java.util.ArrayList;
import java.util.List;

/**
 * ProductContainerUI:
 * <p>
 * Creado por bpena el 23/04/2017.
 */
@Funtionallity(name = "Producto")
@Navigation(
        views = {
                @View(uri = "create", target = ve.com.pt.demo.ProductDetailView.class, mode = ViewMode.EDIT),
                @View(uri = "edit", target = ve.com.pt.demo.ProductDetailView.class, mode = ViewMode.EDIT),
                @View(uri = "detail", target = ve.com.pt.demo.ProductDetailView.class),
                @View(uri = "list", target = ve.com.pt.demo.ProductListView.class)
        }
)
public class ProductContainerUI extends BaseContainerUI {
    @Override
    protected void buildActionMenu() {
        super.buildActionMenu();

        List<BaseMenuItem> menuItems = new ArrayList<BaseMenuItem>();
        menuItems.add(new BaseMenuItem().setCaption("create").setUriApp("producto/create").setViewMode(ViewMode.EDIT));
        menuItems.add(new BaseMenuItem().setCaption("edit").setUriApp("producto/edit").setViewMode(ViewMode.EDIT));
        menuItems.add(new BaseMenuItem().setCaption("list").setUriApp("producto/list"));
        menuItems.add(new BaseMenuItem().setCaption("eliminar").setUriApp("delete").setMenuType(MenuType.ACTION));

        actionMenu.setActionMenuItem(menuItems);
    }

    @Subscribe
    protected void saludo(ActionEvent event) {
        System.out.println("Saludando");
    }
}
