package core;
import java.util.*;

public class Weapon extends Item {
    private double mindamage;
    private double maxdamage;
    private double durability;
    private int speed;
    private double critical;
    private String type;
    private String damagetype;
    private boolean isRanged = false;
    private double minrangeddamage = 0.0;
    private double maxrangeddamage = 0.0;
    private Item ammo = null;
    private int reloadtime = 0;
    public Weapon(int i, double min, double max) {
        super(i);
        mindamage = min;
        maxdamage = max;
        durability = 0.0;
        speed = 0;
        critical = 0;
        type = "";
        damagetype = "";
    }
    public Weapon(int i, double min, double max, double dur, int s, double c, String t, String dt) {
        super(i);
        mindamage = min;
        maxdamage = max;
        durability = dur;
        speed = s;
        critical = c;
        type = t;
        damagetype = dt;
    }
    public double getMinDamage() {
        return mindamage;
    }
    public double getMaxDamage() {
        return maxdamage;
    }
    public double getDurability() {
        return durability;
    }
    public int getSpeed() {
        return speed;
    }
    public double getCritical() {
        return critical;
    }
    public String getType() {
        return type;
    }
    public String getDamageType() {
        return damagetype;
    }
    public boolean isRanged() {
        return isRanged;
    }
    public double getMinRangedDamage() {
        return minrangeddamage;
    }
    public double getMaxRangedDamage() {
        return maxrangeddamage;
    }
    public Item getAmmo() {
        return ammo;
    }
    public int getReloadTime() {
        return reloadtime;
    }
    public void setMinDamage(double min) {
        mindamage = min;
    }
    public void setMaxDamage(double max) {
        maxdamage = max;
    }
    public void setDurability(double d) {
        durability = d;
    }
    public void setSpeed(int s) {
        speed = s;
    }
    public void setCritical(double c) {
        critical = c;
    }
    public void setType(String t) {
        type = t;
    }
    public void setDamageType(String dt) {
        damagetype = dt;
    }
    public void setIsRanged(boolean r) {
        isRanged = r;
    }
    public void setMinRangedDamage(double d) {
        minrangeddamage = d;
    }
    public void setMaxRangedDamage(double d) {
        maxrangeddamage = d;
    }
    public void setAmmo(Item a) {
        ammo = a;
    }
    public void setReloadTime(int t) {
        reloadtime = t;
    }
}