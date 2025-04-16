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
        root.setStyle("-fx-background-color: #e0f7fa;");

        Button refreshBtn = new Button("Refresh Leaderboard");
        refreshBtn.setStyle( "-fx-background-color: #00796b; -fx-text-fill: white");
        refreshBtn.setOnAction(e -> updateLeaderboard());

        Label resultLbl = new Label("Event Results:");
        resultLbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #00796b;");
        Label scoreLbl = new Label("Overall Scores:");
        scoreLbl.setStyle("-fx-font-size: 16px; -fx-font-weight: bold; -fx-text-fill: #00796b;");
        root.getChildren().addAll(resultLbl, eventResultsList, scoreLbl, totalScoresArea, refreshBtn);
    }

    private void updateLeaderboard() {
        eventResultsList.getItems().clear();
        Map<String, Integer> swimmerScores = new HashMap<>();

        for (Event event : MeetGeneratorView.getEvents()) {
            List<Swimmer> swimmers = new ArrayList<>(event.getSwimmers());
            // Sort swimmers by their race time ( set in HeatEntryView)
            swimmers.sort(Comparator.comparingDouble(s -> {
                try {
                    return Double.parseDouble(s.getBestTime(event.getName()));
                } catch (Exception e) {
                    return Double.MAX_VALUE; // no time entered yet
                }
            }));

            eventResultsList.getItems().add(event.getName());

            int placement = 1;
            for (Swimmer s : swimmers) {
                String time = s.getBestTime(event.getName());
            
                if (time == null || time.isBlank()) {
                    continue; // Skip swimmrr with no time
                }
            
                String entry = placement + ". " + s.getName() + " - " + time;
                eventResultsList.getItems().add("    " + entry);
            
                // Score: 6-5-4-3-2-1 for top 6
                if (placement <= 6) {
                    swimmerScores.put(s.getName(),
                        swimmerScores.getOrDefault(s.getName(), 0) + (7 - placement));
                }
            
                placement++;
            }
            

            eventResultsList.getItems().add(""); // spacing
        }

        // Show scores
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
