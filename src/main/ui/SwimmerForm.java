package main.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.model.Swimmer;

import java.util.ArrayList;
import java.util.List;

public class SwimmerForm {

    private VBox root = new VBox(20);
    private static List<Swimmer> swimmerDatabase = new ArrayList<>();
    private TableView<Swimmer> swimmerTable = new TableView<>();

    public SwimmerForm() {
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #f0f8ff;"); // Light blue background

        Label header = new Label("Add Swimmers");
        header.setFont(new Font("Arial", 24));
        header.setTextFill(Color.DARKBLUE);

        HBox inputRow = new HBox(15);
        inputRow.setPadding(new Insets(10));

        TextField nameField = new TextField();
        nameField.setPromptText("Enter Swimmer Name");
        nameField.setPrefWidth(200);
        nameField.setFont(new Font(14));

        Button addButton = new Button("Add");
        addButton.setFont(new Font(14));
        addButton.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        addButton.setPrefHeight(30);

        inputRow.getChildren().addAll(new Label("Name:"), nameField, addButton);

        // Table setup
        TableColumn<Swimmer, String> nameCol = new TableColumn<>("Swimmer");
        nameCol.setCellValueFactory(data -> data.getValue().nameProperty());
        nameCol.setPrefWidth(300);

        swimmerTable.getColumns().add(nameCol);
        swimmerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        swimmerTable.setPrefHeight(250);

        // Add swimmer action
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            if (!name.isEmpty()) {
                Swimmer swimmer = new Swimmer(name);
                swimmerDatabase.add(swimmer);
                swimmerTable.getItems().add(swimmer);
                nameField.clear();
            }
        });

        root.getChildren().addAll(header, inputRow, swimmerTable);
    }

    public Pane getPane() {
        return root;
    }

    public static List<Swimmer> getSwimmerList() {
        return swimmerDatabase;
    }
}
