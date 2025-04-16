package main.ui;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.model.*;

import java.util.ArrayList;
import java.util.List;

public class MeetGeneratorView {

    private VBox root;
    private ComboBox<PracticeType> practiceTypeSelector;
    private ListView<String> eventListView;

    public static List<Event> generatedEvents = new ArrayList<>();

    public MeetGeneratorView() {
        root = new VBox(20);
        root.setPadding(new Insets(20));
        root.setStyle("-fx-background-color: #e0f7fa;");
        // root.setPrefWidth(800);

        Label title = new Label("Practice Type Selection");
        title.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #00796b;");

        practiceTypeSelector = new ComboBox<>();
        practiceTypeSelector.getItems().addAll(PracticeType.values());
        practiceTypeSelector.setPrefWidth(300);
        practiceTypeSelector.setStyle("-fx-font-size: 14px;");

        Button generateBtn = new Button("Generate Meet");
        generateBtn.setStyle("-fx-font-size: 16px; -fx-background-color: #00796b; -fx-text-fill: white; -fx-padding: 8px 8px;");
        generateBtn.setOnAction(e -> {
            PracticeType selected = practiceTypeSelector.getValue();
            if (selected != null) {
                generateMeet(selected);
            }
        });

        Label eventLabel = new Label("Generated Events:");
        eventLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #004d40;");

        eventListView = new ListView<>();
        eventListView.setPrefHeight(400);
        eventListView.setStyle("-fx-font-size: 14px;");

        root.getChildren().addAll(title, practiceTypeSelector, generateBtn, eventLabel, eventListView);
    }

    private void generateMeet(PracticeType type) {
        generatedEvents.clear();
        eventListView.getItems().clear();

        for (String eventName : type.getEvents()) {
            Event event = new Event(eventName);
            for (Swimmer s : SwimmerForm.getSwimmerList()) {
                event.addSwimmer(s); // Add all swimmers to each event
            }
            generatedEvents.add(event);
            eventListView.getItems().add(event.getName() + " (" + event.getSwimmers().size() + " swimmers)");
        }
    }

    public Pane getPane() {
        return root;
    }

    public static List<Event> getEvents() {
        return generatedEvents;
    }
}
