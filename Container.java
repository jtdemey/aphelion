package core;
import java.util.*;

public class Container {
    private String containerName;
    private boolean lootable;
    private boolean enterable;
    private boolean locked;
    private ArrayList<Item> containedItems;
    public Container() {
        containerName = "<unnamed container>";
        lootable = false;
        enterable = false;
        locked = false;
        containedItems = new ArrayList<Item>();
    }
    public Container(String n, boolean l, boolean e, boolean o, ArrayList<Item> c) {
        containerName = n;
        lootable = l;
        enterable = e;
        locked = o;
        containedItems = c;
    }
    public String getContainerName() {
        return containerName;
    }
    public boolean isLootable() {
        return lootable;
    }
    public boolean isEnterable() {
        return enterable;
    }
    public boolean isLocked() {
        return locked;
    }
    public ArrayList<Item> getContainedItems() {
        return containedItems;
    }
    public void setContainerName(String n) {
        containerName = n;
    }
    public void setLootable(boolean l) {
        lootable = l;
    }
    public void setEnterable(boolean e) {
        enterable = e;
    }
    public void setLocked(boolean l) {
        locked = l;
    }
    public void addItem(Item i) {
        containedItems.add(i);
    }
    public void removeItem(Item i) {
        containedItems.remove(i);
    }
    public void clearItems() {
        containedItems.clear();
    }
}