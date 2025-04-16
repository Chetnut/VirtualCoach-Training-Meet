package main.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HeatView {
    public Pane getPane() {
        Pane pane = new Pane();
        pane.getChildren().add(new Label("Heat view goes here"));
        return pane;
    }
}