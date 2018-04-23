package mcxf_androidcom.com.mcx_android;

import java.util.ArrayList;

/**
 * Created by hp on 21-06-2016.
 */
public class GroupItems {

    private String Name;
    private int images;
    private int expand_icon;

    public int getExpand_icon() {
        return expand_icon;
    }

    public void setExpand_icon(int expand_icon) {
        this.expand_icon = expand_icon;
    }

    private ArrayList<ChildItems> Items;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public ArrayList<ChildItems> getItems() {
        return Items;
    }

    public void setItems(ArrayList<ChildItems> items) {
        Items = items;
    }
}
