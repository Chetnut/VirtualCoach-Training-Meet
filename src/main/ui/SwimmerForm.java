package main.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.model.Swimmer;

import java.util.ArrayList;
import java.util.List;

public class SwimmerForm {
    private VBox layout;
    private TextField nameField;
    private TableView<Swimmer> swimmerTable;
    private List<Swimmer> swimmerList = new ArrayList<>();

    public SwimmerForm() {
        layout = new VBox(10);
        layout.setPadding(new Insets(10));

        // Form
        Label title = new Label("Add New Swimmer");
        nameField = new TextField();
        nameField.setPromptText("Swimmer Name");

        Button addButton = new Button("Add Swimmer");
        addButton.setOnAction(e -> addSwimmer());

        // Table
        swimmerTable = new TableView<>();
        TableColumn<Swimmer, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getName()));
        swimmerTable.getColumns().addAll(nameCol);

        layout.getChildren().addAll(title, nameField, addButton, new Label("Swimmer Roster:"), swimmerTable);
    }

    private void addSwimmer() {
        String name = nameField.getText();

        if (!name.isEmpty()) {
            Swimmer s = new Swimmer(name);
            swimmerList.add(s);
            swimmerTable.getItems().add(s);
            nameField.clear();
        }
    }

    public Pane getPane() {
        return layout;
    }

    public List<Swimmer> getSwimmers() {
        return swimmerList;
    }
}
