package main.ui;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ResultEntryView {
    public Pane getPane() {
        Pane pane = new Pane();
        pane.getChildren().add(new Label("Result entry view goes here"));
        return pane;
    }
}
