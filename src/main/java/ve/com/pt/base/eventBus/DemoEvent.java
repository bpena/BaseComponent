package ve.com.pt.base.eventBus;

/**
 * Created by bpena on 4/20/17.
 */
public class DemoEvent {
    private String value;

    public DemoEvent(String value) {
        this.value = value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
