package main.model;

public class Swimmer {
    private String name;
    private String group;

    public Swimmer(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public String getName() { return name; }
    public String getGroup() { return group; }
}