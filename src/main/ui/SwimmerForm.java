package main.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.Color;
import main.model.Swimmer;

import java.util.ArrayList;
import java.util.List;

public class SwimmerForm {

    private VBox root = new VBox(20);
    private static List<Swimmer> swimmerDatabase = new ArrayList<>();
    private TableView<Swimmer> swimmerTable = new TableView<>();

    public SwimmerForm() {
        root.setPadding(new Insets(30));
        root.setStyle("-fx-background-color: #e0f7fa;"); // Light blue like MeetGenerator

        Label title = new Label("Add Swimmers");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #00796b;");

        HBox inputRow = new HBox(10);
        inputRow.setPadding(new Insets(10, 0, 10, 0));

        Label nameLabel = new Label("Name:");
        nameLabel.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #00796b;");
        TextField nameField = new TextField();
        nameField.setPromptText("Enter Swimmer Name");
        nameField.setStyle("-fx-pref-width: 200px; -fx-pref-height: 40px; -fx-font-size: 16px;");


        Button addButton = new Button("Add");
        addButton.setStyle("-fx-font-size: 16px; -fx-background-color: #00796b; -fx-text-fill: white; -fx-pref-height: 40px; -fx-pref-width: 60;");

        inputRow.getChildren().addAll(nameLabel, nameField, addButton);

        TableColumn<Swimmer, String> nameCol = new TableColumn<>("Swimmer Name");
        nameCol.setCellValueFactory(data -> data.getValue().nameProperty());
        nameCol.setPrefWidth(600);

        swimmerTable.getColumns().add(nameCol);
        // swimmerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        swimmerTable.setPrefHeight(300);

        addButton.setOnAction(e -> {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                Swimmer swimmer = new Swimmer(name);
                swimmerDatabase.add(swimmer);
                swimmerTable.getItems().add(swimmer);
                nameField.clear();
            }
        });

        root.getChildren().addAll(title, inputRow, swimmerTable);
    }

    public Pane getPane() {
        return root;
    }

    public static List<Swimmer> getSwimmerList() {
        return swimmerDatabase;
    }
}
