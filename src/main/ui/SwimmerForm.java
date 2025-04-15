package main.ui;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;
import main.model.Swimmer;

public class SwimmerForm {
    private VBox root = new VBox(10);
    private static List<Swimmer> swimmers = new ArrayList<>();

    public SwimmerForm() {
        TextField nameField = new TextField();
        TextField groupField = new TextField();
        Button addBtn = new Button("Add Swimmer");
        addBtn.setOnAction(e -> {
            swimmers.add(new Swimmer(nameField.getText(), groupField.getText()));
            nameField.clear();
            groupField.clear();
        });
        root.getChildren().addAll(new Label("Name:"), nameField, new Label("Group:"), groupField, addBtn);
    }

    public VBox getPane() { return root; }
    public static List<Swimmer> getSwimmers() { return swimmers; }
}