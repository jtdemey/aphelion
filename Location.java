package core;
import java.util.*;

public class Location {
    private String name;
    private ArrayList<Exit> paths;
    private int visibility;
    private int temperature;
    private ArrayList<Item> items;
    private String enterphrase;
    private String exitphrase;
    private HashMap<String,String> features;
    private ArrayList<String> observations;
    private ArrayList<Container> containers;
    private boolean visited;
    public Location() {
        name = "<undefined>";
        paths = new ArrayList<Exit>();
        visibility = 100;
        temperature = 20;
        items = new ArrayList<Item>();
        enterphrase = "";
        exitphrase = "";
        features = new HashMap<String,String>();
        observations = new ArrayList<String>();
        containers = new ArrayList<Container>();
        visited = false;
    }
    public Location(String n) {
    	name = n;
    	paths = new ArrayList<Exit>();
        visibility = 100;
        temperature = 20;
        items = new ArrayList<Item>();
        enterphrase = "";
        exitphrase = "";
        features = new HashMap<String,String>();
        observations = new ArrayList<String>();
        visited = false;
    }
    public void addItem(Item it) {
        items.add(it);
    }
    public void addFeature(String feature, String desc) {
    	features.put(feature, desc);
    }
    public void addContainer(Container container) {
    	containers.add(container);
    }
    public void removeItem(Item it) {
        items.remove(it);
    }
    public void addExit(Exit e) {
        paths.add(e);
    }
    public void deleteExit(Exit e) {
        paths.remove(e);
    }
    public String getName() {
        return name;
    }
    public ArrayList<Exit> getPaths() {
        return paths;
    }
    public int getVisibility() {
        return visibility;
    }
    public int getTemperature() {
        return temperature;
    }
    public ArrayList<Item> getItems() {
        return items;
    }
    public String getEnterPhrase() {
    	return enterphrase;
    }
    public String getExitPhrase() {
    	return exitphrase;
    }
    public HashMap<String, String> getFeatures() {
        return features;
    }
    public ArrayList<String> getObservations() {
        return observations;
    }
    public ArrayList<Container> getContainers() {
    	return containers;
    }
    public boolean isVisited() {
        return visited;
    }
    public void setName(String n) {
        name = n;
    }
    public void setPaths(ArrayList<Exit> p) {
        paths = p;
    }
    public void setVisibility(int v) {
        visibility = v;
    }
    public void setTemperature(int t) {
        temperature = t;
    }
    public void setItems(ArrayList<Item> i) {
        items = i;
    }
    public void setEnterPhrase(String p) {
    	enterphrase = p;
    }
    public void setExitPhrase(String e) {
    	exitphrase = e;
    }
    public void setFeatures(HashMap<String,String> f) {
        features = f;
    }
    public void setObservations(ArrayList<String> o) {
        observations = o;
    }
    public void setContainers(ArrayList<Container> o) {
        containers = o;
    }
    public void setVisited(boolean v) {
        visited = v;
    }
}