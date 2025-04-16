package main.model;

import java.util.ArrayList;
import java.util.List;

public class Event {
    private String name;
    private List<Swimmer> swimmers = new ArrayList<>();

    public Event(String name) {
        this.name = name;
    }

    public void addSwimmer(Swimmer swimmer) {
        swimmers.add(swimmer);
    }

    public List<Swimmer> getSwimmers() {
        return swimmers;
    }

    public String getName() {
        return name;
    }
}
