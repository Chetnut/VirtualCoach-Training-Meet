package main.ui;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class MainView {
    private TabPane root;

    public MainView() {
        root = new TabPane();
        
        root.getTabs().add(new Tab("Swimmer Setup", new SwimmerForm().getPane()));
        root.getTabs().add(new Tab("Meet Generator", new MeetGeneratorView().getPane()));
        root.getTabs().add(new Tab("Heat Entry", new HeatEntryView().getPane()));
        root.getTabs().add(new Tab("Leaderboard", new LeaderboardView().getPane()));

        root.setStyle(/* "-fx-background-color: #e0f7fa;" */ "-fx-font-size: 16");
    }

    public TabPane getRoot() {
        return root;
    }
}
