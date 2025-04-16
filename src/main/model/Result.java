package main.model;

public class Result {
    private Swimmer swimmer;
    private double time;

    public Result(Swimmer swimmer, double time) {
        this.swimmer = swimmer;
        this.time = time;
    }

    public Swimmer getSwimmer() {
        return swimmer;
    }

    public double getTime() {
        return time;
    }
}
