package main.ui;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import main.model.PracticeType;

public class PracticeSelector {
    private ComboBox<PracticeType> dropdown;

    public Pane getPane() {
        VBox root = new VBox(10);
        Label label = new Label("Select practice type:");
        dropdown = new ComboBox<>();
        dropdown.getItems().addAll(PracticeType.values());
        dropdown.getSelectionModel().selectFirst(); // Default selection

        root.getChildren().addAll(label, dropdown);
        return root;
    }

    public PracticeType getSelectedType() {
        return dropdown.getValue();
    }
}
