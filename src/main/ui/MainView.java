package main.ui;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainView {
    private TabPane root;

    public MainView() {
        root = new TabPane();

        root.getTabs().add(new Tab("Swimmers", new SwimmerForm().getPane()));
        // You'll later add: Events, Heats, Results, etc.
    }

    public TabPane getRoot() {
        return root;
    }
}
