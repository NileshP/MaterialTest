package miway.com.materialtest;

/**
 * Created by Mallinath on 6/20/2015.
 */
public class CustomViewData {

    private int iconId;
    private String name;
    private int clickId;
    private boolean isItem;

    public CustomViewData(int iconId, String name,int clickId,boolean isItem) {
        this.iconId = iconId;
        this.name = name;
        this.clickId = clickId;
        this.isItem= isItem;
    }

    public boolean isItem() {
        return isItem;
    }

    public void setItem(boolean isItem) {
        this.isItem = isItem;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClickId() {
        return clickId;
    }

    public void setClickId(int clickId) {
        this.clickId = clickId;
    }
}
