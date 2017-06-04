package core;
import java.util.*;

public class Player {
    private String name;
    private static double health;
    private static double energy;
    private static double sanity;
    Item[] inventory;
    Item[] equipment;
    private static boolean incombat;
    private Location currentLocation;
    private EntityStats playerStats;
    public Player() {
        name = "<undefined>";
        health = 100.0;
        energy = 100.0;
        sanity = 100.0;
        inventory = new Item[24];
        for(int i = 0; i < inventory.length; i++) {
            inventory[i] = null;
        }
        equipment = new Item[12];
        for(int i = 0; i < equipment.length; i++) {
            equipment[i] = null;
        }
        incombat = false;
        currentLocation = null;
        playerStats = new EntityStats();
    }
    public Player(double h, double e, double s) {
        name = "<undefined>";
        health = h;
        energy = e;
        sanity = s;
        inventory = new Item[24];
        for(int i = 0; i < inventory.length; i++) {
            inventory[i] = null;
        }
        equipment = new Item[12];
        for(int i = 0; i < equipment.length; i++) {
            equipment[i] = null;
        }
        incombat = false;
        currentLocation = null;
        playerStats = new EntityStats();
    }
    public void onTick(long tick) {
    	if((tick % 4) == 0) {
    		setEnergy(getEnergy() - 0.1);
    	}
    }
    public void pickUp(Item it) {
        for(int i = 0; i < inventory.length; i++) {
            if(inventory[i] == null) {
                inventory[i] = it;
                System.out.println("You pick up the " + it.getItemName());
                return;
            }
        }
        Random rand = new Random();
        int temp = rand.nextInt(4);
        switch(temp) {
            case 0:
                System.out.println("You are overencumbered.");
                break;
            case 1:
                System.out.println("You cannot carry any more items.");
                break;
            case 2:
                System.out.println("Your inventory is full.");
                break;
            case 3:
                System.out.println("You have no room for this item.");
                break;
        }
    }
    public void drop(Item it) {
        for(int i = 0; i < inventory.length; i++) {
            if(inventory[i] == it) {
                if(it.canDrop() == false) {
                    System.out.println("You probably should not drop this item.");
                    return;
                }
                inventory[i] = null;
                currentLocation.addItem(it);
                System.out.println("You drop the " + it.getItemName() + ".");
                return;
            }
        }
        System.out.println("Item not found.");
    }
    public void showInventory() {
        System.out.println(" /=====================INVENTORY=====================\\ ");
        for(int i = 0; i < inventory.length; i++) {
            if(inventory[i] != null) {
                System.out.println((i+1) + ": " + inventory[i].getItemName());
            }
        }
        System.out.println(" \\===================================================/ ");
    }
    public String getName() {
        return name;
    }
    public double getHealth() {
        return health;
    }
    public double getEnergy() {
        return energy;
    }
    public double getSanity() {
        return sanity;
    }
    public boolean isInCombat() {
    	return incombat;
    }
    public Location getCurrentLocation() {
        return currentLocation;
    }
    public void setName(String n) {
        name = n;
    }
    public void setHealth(double h) {
        health = h;
    }
    public void setEnergy(double e) {
        energy = e;
    }
    public void setSanity(double s) {
        sanity = s;
    }
    public void enterCombat() {
    	incombat = true;
    }
    public void exitCombat() {
    	incombat = false;
    }
    public void setCurrentLocation(Location l) {
        currentLocation = l;
    }
}