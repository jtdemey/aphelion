package core;
import java.util.*;

public class Exit {
    public static final int UNDEFINED = 0;
    public static final int NORTH = 1;
    public static final int SOUTH = 2;
    public static final int EAST  = 3;
    public static final int WEST  = 4;
    public static final int NORTHEAST = 5;
    public static final int NORTHWEST = 6;
    public static final int SOUTHEAST = 7;
    public static final int SOUTHWEST = 8;
    public static final int UP    = 9;
    public static final int DOWN  = 10;
    public static final int IN = 11;
    public static final int OUT = 12;
    public static final String[] directions = {
        "UNDEFINED",
        "NORTH",
        "SOUTH",
        "EAST",
        "WEST",
        "NORTHEAST",
        "NORTHWEST",
        "SOUTHEAST",
        "SOUTHWEST",
        "UP",
        "DOWN",
        "IN",
        "OUT"
    };
    public static final String[] directionsalt = {
        "NULL",
        "N",
        "S",
        "E",
        "W",
        "NE",
        "NW",
        "SE",
        "SW",
        "UPWARD",
        "DOWNWARD",
        "INSIDE",
        "OUTSIDE"       
    };
    private Location leadsTo;
    private int direction;
    private String directionName;
    private String directionNameAlt;
    private boolean canLookThrough;
    private String lookThroughPhrase;
    private int uses;
    public Exit() {
        leadsTo = null;
        direction = Exit.UNDEFINED;
        directionName = directions[0];
        directionNameAlt = directionsalt[0];
        canLookThrough = false;
        lookThroughPhrase = "<null phrase>";
        uses = 0;
    }
    public Exit(Location l, int d, boolean lt, String ltp) {
       leadsTo = l;
       direction = d;
       directionName = directions[d];
       directionNameAlt = directionsalt[d];
       canLookThrough = lt;
       lookThroughPhrase = ltp;
       uses = 0;
    }
    public void incrementUses() {
        uses = uses + 1;
    }
    public String getDirectionName() {
        return directionName;
    }
    public String getDirectionNameAlt() {
        return directionNameAlt;
    }
    public Location getDestination() {
        return leadsTo;
    }
    public int getUses() {
        return uses;
    }
    public void setDirectionName(String d) {
        directionName = d;
    }
    public void setDirectionNameAlt(String a) {
        directionNameAlt = a;
    }
    public void setLeadsTo(Location l) {
        leadsTo = l;
    }
    public void setUses(int u) {
        uses = u;
    }
}