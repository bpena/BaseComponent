package ve.com.pt.base.components.custom.menues.actionMenu;

import com.google.common.eventbus.EventBus;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ve.com.pt.base.components.custom.menues.BaseMenuItem;
import ve.com.pt.base.components.custom.menues.MenuType;
import ve.com.pt.base.core.views.ActionEvent;
import ve.com.pt.base.core.views.main.MainUIConstants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * ActionMenu:
 *
 * Creado por bpena el 21/04/2017.
 */
public class ActionMenu extends MenuBar {
    private EventBus bus;
    private List<BaseMenuItem> itemList;

    public ActionMenu() {
        this.bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);
        this.bus.register(this);

        this.itemList = new ArrayList<>();

        this.addStyleName("action-menu");
    }

    protected void buildActionMenu() {
        this.removeItems();
        this.itemList.forEach(item -> {
            this.addItem(
                    item.getCaption(),
                    item.getUriIcon(),
                    menuItem -> action(item)
            );
        });
    }

    private void action(BaseMenuItem item) {
        if (MenuType.ACTION.equals(item.getMenuType())) {
            EventBus bus = (EventBus) UI.getCurrent().getSession().getAttribute(MainUIConstants.BUS_NAME);
            bus.post(new ActionEvent(item.getUriApp()));
        }
        else if (MenuType.NAVIGATION.equals(item.getMenuType())) {
            UI.getCurrent().getNavigator().navigateTo(item.getUriApp());
        }
    }

    public void setActionMenuItem(String jsonPath) {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader(jsonPath));
            JSONArray jsonArray = (JSONArray) obj;

            jsonArray.forEach(actionMenuObject -> {
                JSONObject actionMenuJson = (JSONObject) actionMenuObject;
                JSONArray actionMenuJsonArray = (JSONArray) actionMenuJson.get("actionMenu");

                actionMenuJsonArray.forEach(actionMenuItem -> {
                    this.itemList.add(
                        new BaseMenuItem()
                            .setCaption(String.valueOf(((JSONObject) actionMenuItem).get("caption")))
                            .setUriIcon(VaadinIcons.valueOf((String) ((JSONObject) actionMenuItem).get("uriIcon")))
                            .setUriApp((String) ((JSONObject) actionMenuItem).get("uriApp"))
                    );
                });
            });

            this.buildActionMenu();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setActionMenuItem(List<BaseMenuItem> itemList) {
        this.itemList = itemList;
        this.buildActionMenu();
    }
}
