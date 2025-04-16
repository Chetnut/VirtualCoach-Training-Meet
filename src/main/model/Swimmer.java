package main.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.HashMap;
import java.util.Map;

public class Swimmer {

    private StringProperty name;
    private Map<String, String> bestTimes = new HashMap<>();

    public Swimmer(String name) {
        this.name = new SimpleStringProperty(name);
    }

    // Name-related methods
    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    // Best time access
    public void setBestTime(String eventName, String time) {
        bestTimes.put(eventName, time);
    }

    public String getBestTime(String eventName) {
        return bestTimes.getOrDefault(eventName, "");  // Empty if not recorded
    }

    public Map<String, String> getAllBestTimes() {
        return bestTimes;
    }
}
