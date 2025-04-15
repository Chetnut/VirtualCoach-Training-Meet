package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import main.ui.MainView;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        MainView view = new MainView();
        primaryStage.setTitle("Mock Meet Trainer");
        primaryStage.setScene(new Scene(view.getRoot(), 800, 600));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}