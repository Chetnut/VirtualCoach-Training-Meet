package main.model;

import java.util.List;

public class Heat {
    private int heatNumber;
    private List<Swimmer> swimmers;

    public Heat(int heatNumber, List<Swimmer> swimmers) {
        this.heatNumber = heatNumber;
        this.swimmers = swimmers;
    }

    public int getHeatNumber() {
        return heatNumber;
    }

    public List<Swimmer> getSwimmers() {
        return swimmers;
    }
}
