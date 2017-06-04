package core;
import java.util.*;

public class Equipment extends Item {
    private double defense;
    private double effectVal;
    private String effectPhrase;
    private int equipSlot;
    /*Slots:
     * 0=none
     * 1=head
     * 2=body
     * 3=legs
     * 4=feet
     * 5=left arm
     * 6=right arm
     * 7=arms
     * 8=left hand
     * 9=right hand
     * 10=hands
     * 11=back
     */
    private boolean isEquipped;
    public Equipment(int i) {
        super(i);
        defense = 0;
        effectVal = 0;
        effectPhrase = "<no effect>";
        equipSlot = 0;
        isEquipped = false;
    }
    public Equipment(int i, double d, double v, String p, int s, boolean e) {
        super(i);
        defense = d;
        effectVal = v;
        effectPhrase = p;
        equipSlot = s;
        isEquipped = e;
    }
    public Equipment(int i, String n, double w, boolean p, boolean t, boolean c, boolean st, double d, double v, String ph, int s, boolean e) {
        super(i, n, w, p, t, c, st);
        defense = d;
        effectVal = v;
        effectPhrase = ph;
        equipSlot = s;
        isEquipped = e;
    }
    public double getDefense() {
        return defense;
    }
    public double getEffectVal() {
        return effectVal;
    }
    public String getEffectPhrase() {
        return effectPhrase;
    }
    public int getEquipSlot() {
        return equipSlot;
    }
    public boolean isEquipped() {
        return isEquipped;
    }
    public void setDefense(double d) {
        defense = d;
    }
    public void setEffectVal(double v) {
        effectVal = v;
    }
    public void setEffectPhrase(String p) {
        effectPhrase = p;
    }
    public void setEquipSlot(int s) {
        equipSlot = s;
    }
    public void setEquipped(boolean e) {
        isEquipped = e;
    }
}