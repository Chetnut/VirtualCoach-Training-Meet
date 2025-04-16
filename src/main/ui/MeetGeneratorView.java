package main.ui;

import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import main.model.*;
import main.ui.SwimmerForm;

import java.util.ArrayList;
import java.util.List;

public class MeetGeneratorView {
    private VBox root;
    private ComboBox<PracticeType> practiceTypeSelector;
    private ListView<String> eventListView;

    public static List<Event> generatedEvents = new ArrayList<>();

    public MeetGeneratorView() {
        root = new VBox(10);

        practiceTypeSelector = new ComboBox<>();
        practiceTypeSelector.getItems().addAll(PracticeType.values());

        Button generateBtn = new Button("Generate Meet");

        eventListView = new ListView<>();

        generateBtn.setOnAction(e -> {
            PracticeType selected = practiceTypeSelector.getValue();
            if (selected != null) {
                generateMeet(selected);
            }
        });

        root.getChildren().addAll(new Label("Select Practice Type:"), practiceTypeSelector, generateBtn, new Label("Generated Events:"), eventListView);
    }

    private void generateMeet(PracticeType type) {
        generatedEvents.clear();
        eventListView.getItems().clear();

        for (String eventName : type.getEvents()) {
            Event event = new Event(eventName);
            for (Swimmer s : SwimmerForm.getSwimmerList()) {
                event.addSwimmer(s); // Everyone participates in all events for now
            }
            generatedEvents.add(event);
            eventListView.getItems().add(event.getName() + " (" + event.getSwimmers().size() + " swimmers)");
        }
    }

    public VBox getPane() {
        return root;
    }

    public static List<Event> getEvents() {
        return generatedEvents;
    }
}
