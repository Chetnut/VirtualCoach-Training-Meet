package main.model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private String group;
    private List<Swimmer> swimmers = new ArrayList<>();

    public Event(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public void addSwimmer(Swimmer s) {
        swimmers.add(s);
    }

    public List<Swimmer> getSwimmers() {
        return swimmers;
    }

    public String getName() { return name; }
    public String getGroup() { return group; }
}