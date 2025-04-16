package main.model;

import java.util.HashMap;
import java.util.Map;

public class Swimmer {
    private String name;
    private Map<String, Double> bestTimes = new HashMap<>();

    public Swimmer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBestTime(String event, double time) {
        bestTimes.put(event, time);
    }

    public Double getBestTime(String event) {
        return bestTimes.get(event);
    }

    public Map<String, Double> getAllBestTimes() {
        return bestTimes;
    }
}
