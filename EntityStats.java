package core;
import java.util.*;

public class EntityStats {
    private double strength;
    private double speed;
    private double constitution;
    private double luck;
    private double combat;
    private double defense;
    private double perception;
    private boolean useWeaponProficiencies;
    private double wp_unarmed;
    private double wp_blade;
    private double wp_blunt;
    private double wp_bow;
    private double wp_gun;
    public EntityStats() {
        strength = 1;
        speed = 1;
        constitution = 1;
        luck = 1;
        combat = 1;
        defense = 1;
        perception = 1;
        useWeaponProficiencies = true;
        wp_unarmed = 1;
        wp_blade = 1;
        wp_blunt = 1;
        wp_bow = 1;
        wp_gun = 1;
    }
    public EntityStats(double st, double sp, double co, double lu, double com, double de, double pe,
    boolean uwp, double wpu, double wpb, double wpblu, double wpbo, double wpg) {
        strength = st;
        speed = sp;
        constitution = co;
        luck = lu;
        combat = com;
        defense = de;
        perception = pe;
        useWeaponProficiencies = uwp;
        wp_unarmed = wpu;
        wp_blade = wpb;
        wp_blunt = wpblu;
        wp_bow = wpbo;
        wp_gun = wpg;
    }
    public void display() {
        System.out.println("//STATS////////////");
        System.out.println("STRENGTH:   " + (int)getStrength());
        System.out.println("SPEED:      " + (int)getSpeed());
        System.out.println("FITNESS:    " + (int)getConstitution());
        System.out.println("LUCK:       " + (int)getLuck());
        System.out.println("COMBAT:     " + (int)getCombat());
        System.out.println("DEFENSE:    " + (int)getDefense());
        System.out.println("PERCEPTION: " + (int)getPerception());
        if(useWeaponProficiencies == true) {
            System.out.println("WEAPON PROFICIENCIES: ");
            System.out.println("    UNARMED:    " + (int)getWpUnarmed());
            System.out.println("    BLADES:     " + (int)getWpBlade());
            System.out.println("    BLUNTS:     " + (int)getWpBlunt());
            System.out.println("    ARCHERY:    " + (int)getWpBow());
            System.out.println("    GUNMANSHIP: " + (int)getWpGun());
        }
    }
    public double getStrength() {
        return strength;
    }
    public double getSpeed() {
        return speed;
    }
    public double getConstitution() {
        return constitution;
    }
    public double getLuck() {
        return luck;
    }
    public double getCombat() {
        return combat;
    }
    public double getDefense() {
        return defense;
    }
    public double getPerception() {
        return perception;
    }
    public double getWpUnarmed() {
        return wp_unarmed;
    }
    public double getWpBlade() {
        return wp_blade;
    }
    public double getWpBlunt() {
        return wp_blunt;
    }
    public double getWpBow() {
        return wp_bow;
    }
    public double getWpGun() {
        return wp_gun;
    }
    public void setStrength(double s) {
        strength = s;
    }
    public void setSpeed(double sp) {
        speed = sp;
    }
    public void setConstitution(double c) {
        constitution = c;
    }
    public void setLuck(double l) {
        luck = l;
    }
    public void setCombat(double c) {
        combat = c;
    }
    public void setDefense(double d) {
        defense = d;
    }
    public void setPerception(double p) {
        perception = p;
    }
    public void setWpUnarmed(double wpu) {
        wp_unarmed = wpu;
    }
    public void setWpBlade(double wpb) {
        wp_blade = wpb;
    }
    public void setWpBlunt(double wpb) {
        wp_blunt = wpb;
    }
    public void setWpBow(double wpb) {
        wp_bow = wpb;
    }
    public void setWpGun(double wpg) {
        wp_gun = wpg;
    }
}