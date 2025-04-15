package main.ui;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.util.*;
import main.model.*;

public class EventSetupView {
    private VBox root = new VBox(10);
    private static List<Event> events = new ArrayList<>();

    public EventSetupView() {
        TextField nameField = new TextField();
        TextField groupField = new TextField();
        Button addBtn = new Button("Create Event");
        addBtn.setOnAction(e -> {
            String name = nameField.getText();
            String group = groupField.getText();
            if (!name.isEmpty()) {
                Event event = new Event(name, group);
                for (Swimmer s : SwimmerForm.getSwimmers()) {
                    if (s.getGroup().equalsIgnoreCase(group)) {
                        event.addSwimmer(s);
                    }
                }
                events.add(event);
                nameField.clear();
                groupField.clear();
            }
        });
        root.getChildren().addAll(new Label("Event Name:"), nameField, new Label("Group:"), groupField, addBtn);
    }

    public VBox getPane() { return root; }
}