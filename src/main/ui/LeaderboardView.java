package main.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import main.model.Event;
import main.model.Swimmer;
import main.ui.MeetGeneratorView;

import java.util.*;

public class LeaderboardView {
    private VBox root = new VBox(10);
    private ListView<String> eventResultsList = new ListView<>();
    private TextArea totalScoresArea = new TextArea();

    public LeaderboardView() {
        root.setPadding(new Insets(10));

        Button refreshButton = new Button("Refresh Leaderboard");
        refreshButton.setOnAction(e -> updateLeaderboard());

        root.getChildren().addAll(new Label("Event Results:"), eventResultsList,
                                  new Label("Overall Scores:"), totalScoresArea, refreshButton);
    }

    private void updateLeaderboard() {
        eventResultsList.getItems().clear();
        Map<String, Integer> swimmerScores = new HashMap<>();

        for (Event event : MeetGeneratorView.getEvents()) {
            List<Swimmer> swimmers = new ArrayList<>(event.getSwimmers());
            // Sort swimmers by their race time (assuming set in HeatEntryView)
            swimmers.sort(Comparator.comparingDouble(s -> {
                try {
                    return Double.parseDouble(s.getBestTime(event.getName()));
                } catch (Exception e) {
                    return Double.MAX_VALUE; // No time entered yet
                }
            }));

            eventResultsList.getItems().add(event.getName());

            int placement = 1;
            for (Swimmer s : swimmers) {
                String time = s.getBestTime(event.getName());
            
                if (time == null || time.isBlank()) {
                    continue; // Skip swimmers with no recorded time
                }
            
                String entry = placement + ". " + s.getName() + " - " + time;
                eventResultsList.getItems().add("    " + entry);
            
                // Score: 6 - placement (only top 6 get points)
                if (placement <= 6) {
                    swimmerScores.put(s.getName(),
                        swimmerScores.getOrDefault(s.getName(), 0) + (7 - placement));
                }
            
                placement++;
            }
            

            eventResultsList.getItems().add(""); // spacing between events
        }

        // Show total scores
        StringBuilder scoreBuilder = new StringBuilder();
        swimmerScores.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(entry -> scoreBuilder.append(entry.getKey())
                                              .append(": ")
                                              .append(entry.getValue())
                                              .append("\n"));
        totalScoresArea.setText(scoreBuilder.toString());
    }

    public Pane getPane() {
        return root;
    }
}
