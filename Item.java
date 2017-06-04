package core;
import java.util.*;

public class Item {
    private int itemid;
    private String itemName;
    private String itemDescriptionB;
    private String itemDescriptionV;
    private ArrayList<String> aliases;
    private double weight;
    private boolean canPickUp;
    private boolean canDrop;
    private boolean isThrowable;
    private double throwdamage;
    private boolean isConsumable;
    private boolean isStackable;
    public Item(int i) {
        itemid = i;
        itemName = "";
        itemDescriptionB = "";
        itemDescriptionV = "";
        aliases = new ArrayList<String>();
        weight = 1.0;
        canPickUp = false;
        canDrop = true;
        isThrowable = false;
        throwdamage = 0.0;
        isConsumable = false;
        isStackable = false;
    }
    public Item(int i, String n, double w, boolean p, boolean t, boolean c, boolean s) {
        itemid = i;
        itemName = n;
        itemDescriptionB = "";
        itemDescriptionV = "";
        aliases = new ArrayList<String>();
        weight = w;
        canPickUp = p;
        canDrop = true;
        isThrowable = t;
        throwdamage = 0.0;
        isConsumable = c;
        isStackable = s;
    }
    public void addAlias(String a) {
        aliases.add(a);
    }
    public void removeAlias(String a) {
        aliases.remove(a);
    }
    public int getItemId() {
        return itemid;
    }
    public String getItemName() {
        return itemName;
    }
    public String getItemDescriptionB() {
        return itemDescriptionB;
    }
    public String getItemDescriptionV() {
        return itemDescriptionV;
    }
    public ArrayList<String> getAliases() {
        return aliases;
    }
    public double getWeight() {
        return weight;
    }
    public boolean canPickUp() {
        return canPickUp;
    }
    public boolean canDrop() {
        return canDrop;
    }
    public boolean isThrowable() {
        return isThrowable;
    }
    public double getThrowDamage() {
        return throwdamage;
    }
    public boolean isConsumable() {
        return isConsumable;
    }
    public boolean isStackable() {
        return isStackable;
    }
    public void setItemId(int i) {
        itemid = i;
    }
    public void setItemName(String n) {
        itemName = n;
    }
    public void setItemDescriptionB(String b) {
        itemDescriptionB = b;
    }
    public void setItemDescriptionV(String v) {
        itemDescriptionV = v;
    }
    public void setAliases(ArrayList<String> a) {
        aliases = a;
    }
    public void setWeight(double w) {
        weight = w;
    }
    public void setCanPickUp(boolean p) {
        canPickUp = p;
    }
    public void setCanDrop(boolean d) {
        canDrop = d;
    }
    public void setIsThrowable(boolean t) {
        isThrowable = t;
    }
    public void setThrowDamage(double d) {
        throwdamage = d;
    }
    public void setIsConsumable(boolean c) {
        isConsumable = c;
    }
    public void setIsStackable(boolean s) {
        isStackable = s;
    }
}