package core;
import java.util.*;

public class Parser {
    /* VALID COMMANDS:
     *  QUIT
     *  SAVE
     *  LOAD
     *  GO - Move from Location to an Exit
     *  EXAMINE - Inspect things
     *  PICKUP - Pick up an Item
     *  DROP
     *  OPEN - Open container or an Exit
     *  CLOSE
     *  INVENTORY - Displays Player inventory
     *  MAP - Display Map
     *  JOURNAL - Display Journal
     *  STATS - Display character attributes
     *  TALK - Enter dialogue
     *  ATTACK - Attack an enemy with a weapon/fists
     *  KICK - Chance to stun, breaks open some objects
     *  EQUIP - Move Equipment from inventory to self
     *  UNEQUIP
     *  CONSUME - Use consummable Item
     *  THROW - Throw object at entity
     *  DIE - Make a fatal error
     */
    private ArrayList<String> commands;
    private MainWindow currentWindow;
    public Parser() {
        commands = new ArrayList<String>();
        commands.add("QUIT");
        commands.add("SAVE");
        commands.add("LOAD");
        commands.add("PAUSE");
        commands.add("UNPAUSE");
        commands.add("GO");
        commands.add("EXAMINE");
        commands.add("PICKUP");
        commands.add("DROP");
        commands.add("OPEN");
        commands.add("CLOSE");
        commands.add("INVENTORY");
        commands.add("MAP");
        commands.add("JOURNAL");
        commands.add("STATS");
        commands.add("TALK");
        commands.add("ATTACK");
        commands.add("KICK");
        commands.add("EQUIP");
        commands.add("UNEQUIP");
        commands.add("CONSUME");
        commands.add("THROW");
        commands.add("DIE");
    }
    public Parser(MainWindow w) {
        commands = new ArrayList<String>();
        currentWindow = w;
        commands.add("QUIT");
        commands.add("SAVE");
        commands.add("LOAD");
        commands.add("PAUSE");
        commands.add("UNPAUSE");
        commands.add("GO");
        commands.add("EXAMINE");
        commands.add("PICKUP");
        commands.add("DROP");
        commands.add("OPEN");
        commands.add("CLOSE");
        commands.add("INVENTORY");
        commands.add("MAP");
        commands.add("JOURNAL");
        commands.add("STATS");
        commands.add("TALK");
        commands.add("ATTACK");
        commands.add("KICK");
        commands.add("EQUIP");
        commands.add("UNEQUIP");
        commands.add("CONSUME");
        commands.add("THROW");
        commands.add("DIE");
    }
    /*
    public synchronized void startParserThread() {
        parserThread = new Thread(this);
        parserThread.start();
        parsing = true;
    }
    public synchronized void stopParserThread() {
        try {
            parserThread.join();
            parsing = false;
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void run() {
        while(parsing) {
            String line = input.nextLine();
            
        }
    }
    */
    public String parse(String raw) {
        String parsed = "";
        Random rand = new Random();
        raw = raw.toUpperCase();
        if(raw.length() > 34) {
            int temp = rand.nextInt(5);
            switch(temp) {
                case 0:
                    currentWindow.displayLine("I can't understand that many words.");
                    break;
                case 1:
                    currentWindow.displayLine("I'm only a computer program. Try again.");
                    break;
                case 2:
                    currentWindow.displayLine("Calm down there and type something more understandable.");
                    break;
                case 3:
                    currentWindow.displayLine("Do you expect me to understand all that?");
                    break;
                case 4:
                    currentWindow.displayLine("Input not understood; try to type a simpler command.");
                    break;
            }
            return null;
        }
        String[] rawsplit = raw.split("\\s+");
        String first = rawsplit[0];
        switch(first) {
            default:
                currentWindow.displayLine("'" + first + "' is not a recognizable command.");
                return null;
            case "":
            	return null;
            case "QUIT": case "EXIT":
                parsed = parsed + "QUIT";
            case "GO": case "WALK": case "RUN": case "TRAVEL": case "CLIMB": case "FLEE": case "LEAVE":
                parsed = parsed + "GO/";
                if(rawsplit.length < 2) {
                    int temp1 = rand.nextInt(3);
                        if(temp1 == 0) {
                            currentWindow.displayLine("Please specify a direction.");
                        } else if(temp1 == 1) {
                            currentWindow.displayLine("Go in what direction?");
                        } else if(temp1 == 2) {
                            currentWindow.displayLine("Try specifying a cardinal direction.");
                        }
                        return null;
                }
                String second = rawsplit[1];
                switch(second) {
                    case "N": case "NOR": case "NORT": case "NORTH": case "FORWARD":
                    case "STRAIGHT": case "STRAIGHTFORWARD": case "NORTHWARD": case "NORTHWARDS":
                        parsed = parsed + "1";
                        break;
                    case "S": case "SOU": case "SOUT": case "SOUTH": case "SOUTHWARD":
                    case "SOUTHWARDS":
                        parsed = parsed + "2";
                        break;
                    case "E": case "EA": case "EAS": case "EAST": case "RIGHT":
                    case "RIGHTWARD": case "RIGHTWARDS": case "EASTWARD": case "EASTWARDS":
                        parsed = parsed + "3";
                        break;
                    case "W": case "WE": case "WES": case "WEST": case "WESTWARD":
                    case "WESTWARDS": case "LEFT": case "LEFTWARD": case "LEFTWARDS":
                        parsed = parsed + "4";
                        break;
                    case "NE": case "NORTHEAST": case "NEAST": case "NOREAST": case "NORTEAST":
                    case "NORTHEA": case "NORTHEAS": case "NEAS":
                        parsed = parsed + "5";
                        break;
                    case "NW": case "NORTHWEST": case "NWEST": case "NORWEST": case "NORTWEST":
                    case "NORTHWE": case "NORTHWES": case "NWES":
                        parsed = parsed + "6";
                        break;
                    case "SE": case "SOUTHEAST": case "SEAST": case "SOEAST": case "SOUEAST":
                    case "SOUTEAST": case "SOUTHEA": case "SOUTHEAS": case "SOUTEAS":
                        parsed = parsed + "7";
                        break;
                    case "SW": case "SOUTHWEST": case "SWEST": case "SOWEST": case "SOUWEST":
                    case "SOUTWEST": case "SOUTHWE": case "SOUTHWES": case "SOUTWES":
                        parsed = parsed + "8";
                        break;
                    case "U": case "UP": case "UPWARD": case "UPWARDS": case "ABOVE":
                        parsed = parsed + "9";
                        break;
                    case "D": case "DOWN": case "DOW": case "DOWNWARD": case "DOWNWARDS":
                    case "BELOW": case "UNDER":
                        parsed = parsed + "10";
                        break;
                    case "IN": case "INSIDE":
                        parsed = parsed + "11";
                        break;
                    case "OUT": case "OUTSIDE": case "OUTWARD": case "OUTWARDS": case "OU":
                    case "OUTS":
                        parsed = parsed + "12";
                        break;
                    default:
                        int temp2 = rand.nextInt(3);
                        if(temp2 == 0) {
                            currentWindow.displayLine("Please specify a direction.");
                        } else if(temp2 == 1) {
                            currentWindow.displayLine("Go in what direction?");
                        } else if(temp2 == 2) {
                            currentWindow.displayLine("Try specifying a cardinal direction.");
                        }
                        return null;
                }
                break;
            case "EXAMINE": case "LOOK": case "LOOKAT": case "EXAMIN": case "OBSERVE":
            case "PERCEIVE": case "INSPECT":
                parsed = parsed + "EXAMINE/";
                if(rawsplit.length < 2) {
                    parsed = parsed + "LOCATION";
                    return parsed;
                }
                String second1 = rawsplit[1];
                switch(second1) {
                    case "AT":
                        if(rawsplit.length < 3) {
                            currentWindow.displayLine("Specify something to examine.");
                            return null;
                        }
                        String third = rawsplit[2];
                        parsed = parsed + third;
                        return parsed;
                    case "LOCATION": case "ROOM": case "WHEREABOUTS": case "SURROUNDINGS":
                    case "ENVIRONMENT": case "AROUND": case "SURROUNDING": case "WHERE":
                    case "AHEAD": case "DOWN": case "UP": case "LEFT": case "RIGHT":
                        parsed = parsed + "LOCATION";
                        return parsed;
                    case "INVENTORY": case "ITEMS": case "BACKPACK": case "PACK": case "STUFF":
                    case "THINGS":
                        parsed = "INVENTORY";
                        return parsed;
                    default:
                        parsed = parsed + second1;
                        break;
                }
                break;
            case "PICKUP": case "PICK": case "GRAB": case "ACQUIRE": case "TAKE": case "TAK":
                parsed = parsed + "PICKUP/";
                if(rawsplit.length < 2) {
                    int temp3 = rand.nextInt(3);
                    if(temp3 == 0) {
                        currentWindow.displayLine("Please specify an item to pick up.");
                    } else if(temp3 == 1) {
                        currentWindow.displayLine("You can't pick up nothing.");
                    } else if(temp3 == 2) {
                        currentWindow.displayLine("Try specifying something to pick up.");
                    }
                    return null;
                }
                String second2 = rawsplit[1];
                if(second2 == "UP" && first == "PICK") {
                    if(rawsplit.length < 3) {
                        currentWindow.displayLine("Please specify an item to pick up.");
                        return null;
                    }
                    String third6 = rawsplit[2];
                    parsed = parsed + third6;
                    return parsed;
                }
                parsed = parsed + second2;
                break;
            case "DROP": case "DITCH": case "DISCARD": case "DRO": case "RID":
                parsed = parsed + "DROP/";
                if(rawsplit.length < 2) {
                    currentWindow.displayLine("Specify something to drop.");
                    return null;
                }
                String second3 = rawsplit[1];
                parsed = parsed + second3;
                break;
            case "OPEN": case "ACCESS":
                parsed = parsed + "OPEN/";
                if(rawsplit.length < 2) {
                    currentWindow.displayLine("Specify something to open.");
                    return null;
                }
                String second4 = rawsplit[1];
                parsed = parsed + second4;
                break;
            case "STORE": case "GIVE": case "CONTAIN": case "BESTOW":
                parsed = "STORE/";
                if(rawsplit.length < 2) {
                    currentWindow.displayLine("Please specify what to store and where to put it.");
                    return null;
                }
                String second13 = rawsplit[1];
                if(second13 == "IN" || second13 == "TO" || second13 == "AT" || second13 == "INSIDE") {
                    currentWindow.displayLine("Specify what to store or give and where.");
                    return null;
                } else {
                    parsed = parsed + second13 + "/";
                }
                if(rawsplit.length < 3) {
                    currentWindow.displayLine("Specify where to put the item.");
                    return null;
                }
                String third5 = rawsplit[2];
                if(third5 == "IN" || third5 == "TO" || third5 == "AT" || third5 == "INSIDE") {
                    if(rawsplit.length < 4) {
                        currentWindow.displayLine("Specify what item and where to put it.");
                    }
                    String fourth2 = rawsplit[3];
                    parsed = parsed + fourth2;
                } else {
                    parsed = parsed + third5;
                }
                break;
            case "CLOSE": case "SHUT": case "SEAL":
                parsed = parsed + "CLOSE/";
                if(rawsplit.length < 2) {
                    currentWindow.displayLine("Specify what to close.");
                    return null;
                }
                String second5 = rawsplit[1];
                parsed = parsed + second5;
                break;
            case "INVENTORY": case "BACKPACK": case "PACK": case "ITEMS": case "THINGS":
            case "STUFF": case "SATCHEL": case "BAG": case "POUCH": case "PURSE": case "SACK":
                parsed = "INVENTORY";
                break;
            case "MAP": case "MAPP": case "DIRECTIONS": case "WHEREIS": case "ORIENTATION":
                parsed = "MAP";
                break;
            case "JOURNAL": case "DIARY": case "NOTEBOOK": case "NOTES": case "NOTE": case "JOT":
            case "WRITE": case "NOTATE": case "MEMO":
                parsed = "JOURNAL";
                break;
            case "STATS": case "STATISTICS": case "LEVEL": case "LEVELS": case "ATTRIBUTES": case "ATTRIBUTE": case "CHARACTER": case "STAT": case "XP":
            case "EXP": case "EXPERIENCE": case "LEVELUP": case "SKILLS": case "SKILL":
                parsed = "STATS";
                break;
            case "TALK": case "CONVERSE": case "DIALOGUE":
                parsed = parsed + "TALK/";
                if(rawsplit.length < 2) {
                    currentWindow.displayLine("Please specify who to talk to.");
                    return null;
                }
                String second6 = rawsplit[1];
                if(second6 == "TO" || second6 == "WITH" || second6 == "T" || second6 == "WIT") {
                    if(rawsplit.length < 3) {
                        currentWindow.displayLine("Please specify who to talk to.");
                        return null;
                    }
                    String third1 = rawsplit[2];
                    parsed = parsed + third1;
                    return parsed;
                }
                parsed = parsed + second6;
                break;
            case "ATTACK": case "KILL": case "HURT": case "HARM": case "X": case "STAB": case "SLICE":
            case "BLUDGEON": case "BASH": case "CRIPPLE": case "DAMAGE": case "FIGHT": case "MURDER":
            case "BOP": case "BREAK":
                parsed = parsed + "ATTACK/";
                if(rawsplit.length < 2) {
                    parsed = parsed + "ENEMY";
                    return parsed;
                }
                String second7 = rawsplit[1];
                if(second7 == "WITH" || second7 == "WIT") {
                    if(rawsplit.length < 3) {
                        currentWindow.displayLine("Try specifying what to attack.");
                        return null;
                    }
                    currentWindow.displayLine("Try equipping your weapon and attacking an enemy.");
                    return null;
                } else if(second7 == "SELF" || second7 == "MYSELF" || second7 == "ME") {
                    currentWindow.displayLine("There's no reason to do that.");
                    return null;
                } else if(second7 == "NARRATOR") {
                    currentWindow.displayLine("Now, now. Breaking the fourth wall isn't going to solve anything.");
                    return null;
                } else if(second7 == "ENEMY" || second7 == "OPPONENT" || second7 == "IT" || second7 == "HIM" || second7 == "HER") {
                    parsed = parsed + "ENEMY";
                } else {
                    parsed = parsed + second7;
                }
                if(rawsplit.length > 2) {
                    String third2 = rawsplit[2];
                    if(third2 == "WITH" || third2 == "WIT" || third2 == "W") {
                        if(rawsplit.length < 4) {
                            currentWindow.displayLine("Try equipping a weapon and just indicating what to attack.");
                            return null;
                        }
                        String fourth = rawsplit[3];
                        if(fourth == "FOOT" || fourth == "KICK" || fourth == "LEG" || fourth == "BOOT" || fourth == "SHOE") {
                            parsed = "KICK/" + second7;
                            return parsed;
                        }
                        parsed = parsed + "/" + fourth;
                    } else {
                        currentWindow.displayLine("Try equipping a weapon and attacking.");
                        return null;
                    }
                }
                break;
            case "KICK": case "STOMP": case "K": case "STUN": case "KIC": case "KICKS": case "NAIR":
                parsed = "KICK/";
                if(rawsplit.length < 2) {
                    parsed = parsed + "ENEMY";
                    return parsed;
                }
                String second8 = rawsplit[1];
                if(second8 == "SELF" || second8 == "MYSELF" || second8 == "ME") {
                    currentWindow.displayLine("There's no reason to do that.");
                    return null;
                } else if(second8 == "NARRATOR") {
                    currentWindow.displayLine("Now, now. Breaking the fourth wall isn't going to solve anything.");
                    return null;
                } else if(second8 == "ENEMY" || second8 == "OPPONENT" || second8 == "IT" || second8 == "HIM" || second8 == "HER") {
                    parsed = parsed + "ENEMY";
                } else {
                    parsed = parsed + second8;
                }
            case "EQUIP": case "DON": case "EQIP": case "EQUI":
                parsed = "EQUIP/";
                if(rawsplit.length < 2) {
                    currentWindow.displayLine("Specify what to equip.");
                    return null;
                }
                String second9 = rawsplit[1];
                parsed = parsed + second9;
                break;
            case "UNEQUIP": case "UNEQUI": case "UNEQIP":
                parsed = "UNEQUIP/";
                if(rawsplit.length < 2) {
                    currentWindow.displayLine("Specify what to unequip.");
                    return null;
                }
                String second10 = rawsplit[1];
                parsed = parsed + second10;
                break;
            case "CONSUME": case "EAT": case "INJECT": case "DRINK": case "SWALLOW": case "APPLY":
                parsed = "CONSUME/";
                if(rawsplit.length < 2) {
                    currentWindow.displayLine("Specify what to consume.");
                    return null;
                }
                String second11 = rawsplit[1];
                parsed = parsed + second11;
                break;
            case "THROW": case "TOSS": case "CHUCK": case "HURL":
                parsed = "THROW/";
                if(rawsplit.length < 2) {
                    parsed = parsed + "CURRENT_ITEM/DEFAULT";
                    return parsed;
                }
                String second12 = rawsplit[1];
                if(second12 == "AT" || second12 == "TO" || second12 == "TOWARD" || second12 == "TOWARDS") {
                    if(rawsplit.length < 3) {
                        currentWindow.displayLine("Specify what to throw and where.");
                        return null;
                    }
                    String third3 = rawsplit[2];
                    parsed = parsed + "CURRENT_ITEM/" + third3;
                } else {
                    if(rawsplit.length < 3) {
                        parsed = parsed + second12 + "/DEFAULT";
                        return parsed;
                    }
                    String third4 = rawsplit[2];
                    if(third4 == "AT" || third4 == "TO" || third4 == "TOWARD" || third4 == "TOWARDS") {
                        if(rawsplit.length < 4) {
                            parsed = parsed + second12 + "/DEFAULT";
                            return parsed;
                        }
                        String fourth1 = rawsplit[3];
                        parsed = parsed + second12 + "/" + fourth1;
                        return parsed;
                    } else {
                        parsed = parsed + second12 + "/DEFAULT";
                        return parsed;
                    }
                }
                break;
            case "DIE": case "SUICIDE":
                parsed = "DIE";
                if(rawsplit.length > 1) {
                    currentWindow.displayLine("I don't think that's the most optimal option.");
                    return null;
                }
                break;
        }
        currentWindow.displayLine("PARSED: " + parsed);
        return parsed;
    }
    public MainWindow getCurrentWindow() {
    	return currentWindow;
    }
    public void setWindow(MainWindow w) {
    	currentWindow = w;
    }
}