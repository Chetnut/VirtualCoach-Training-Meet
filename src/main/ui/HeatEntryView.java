package main.ui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.beans.property.SimpleStringProperty;
import main.model.Swimmer;
import main.model.Event;

import java.util.*;

public class HeatEntryView {

    private VBox root = new VBox(10);
    private ComboBox<String> eventSelector = new ComboBox<>();
    private TableView<HeatRow> heatTable = new TableView<>();
    private Map<String, List<HeatRow>> eventHeats = new HashMap<>();

    public HeatEntryView() {
        root.setPadding(new Insets(10));

        Label title = new Label("Enter Heat Results");
        Button refreshBtn = new Button("Load Events");
        refreshBtn.setOnAction(e -> {
            eventSelector.getItems().clear();
            for (Event ev : MeetGeneratorView.getEvents()) {
                eventSelector.getItems().add(ev.getName());
            }
        });

        // Load event names from MeetGeneratorView
        List<Event> events = MeetGeneratorView.getEvents();
        for (Event event : events) {
            eventSelector.getItems().add(event.getName());
        }

        eventSelector.setOnAction(e -> loadSelectedEventHeats(eventSelector.getValue()));
        root.getChildren().addAll(title, refreshBtn, eventSelector);

        // Table columns
        TableColumn<HeatRow, String> nameCol = new TableColumn<>("Swimmer");
        nameCol.setCellValueFactory(data -> data.getValue().nameProperty());

        TableColumn<HeatRow, String> heatCol = new TableColumn<>("Heat");
        heatCol.setCellValueFactory(data -> data.getValue().heatNumberProperty());

        TableColumn<HeatRow, String> timeCol = new TableColumn<>("Time");
        timeCol.setCellValueFactory(data -> data.getValue().timeProperty());

        TableColumn<HeatRow, Void> actionCol = new TableColumn<>("Action");
        actionCol.setCellFactory(col -> new TableCell<>() {
            private final Button enterBtn = new Button("Enter Time");

            {
                enterBtn.setOnAction(e -> {
                    HeatRow row = getTableView().getItems().get(getIndex());
                    TextInputDialog dialog = new TextInputDialog(row.getTime());
                    dialog.setTitle("Enter Time");
                    dialog.setHeaderText("Enter time for " + row.getName());
                    dialog.setContentText("Time:");
                    dialog.showAndWait().ifPresent(time -> {
                        row.setTime(time);
                    
                        // Also update swimmer's best time in the model
                        Optional<Event> match = MeetGeneratorView.getEvents().stream()
                            .filter(ev -> ev.getName().equals(eventSelector.getValue()))
                            .findFirst();
                    
                        if (match.isPresent()) {
                            Event event = match.get();
                            for (Swimmer swimmer : event.getSwimmers()) {
                                if (swimmer.getName().equals(row.getName())) {
                                    swimmer.setBestTime(event.getName(), time);
                                    break;
                                }
                            }
                        }
                    
                        heatTable.refresh();
                    });
                    
                });
            }

            @Override
            protected void updateItem(Void item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setGraphic(null);
                } else {
                    setGraphic(enterBtn);
                }
            }
        });

        heatTable.getColumns().addAll(nameCol, heatCol, timeCol, actionCol);
        heatTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        root.getChildren().add(heatTable);
    }

    private void loadSelectedEventHeats(String eventName) {
        ObservableList<HeatRow> rows = FXCollections.observableArrayList();

        // Only generate once per event
        if (!eventHeats.containsKey(eventName)) {
            Optional<Event> match = MeetGeneratorView.getEvents().stream()
                    .filter(e -> e.getName().equals(eventName))
                    .findFirst();

            if (match.isPresent()) {
                List<Swimmer> swimmers = match.get().getSwimmers();
                List<HeatRow> generatedRows = new ArrayList<>();
                int heatSize = 4;
                for (int i = 0; i < swimmers.size(); i++) {
                    int heatNum = i / heatSize + 1;
                    generatedRows.add(new HeatRow(swimmers.get(i).getName(), heatNum));
                }
                eventHeats.put(eventName, generatedRows);
            }
        }

        rows.setAll(eventHeats.get(eventName));
        heatTable.setItems(rows);
    }

    public Pane getPane() {
        return root;
    }

    // Inner class representing a row in the heat table
    public static class HeatRow {
        private final SimpleStringProperty name = new SimpleStringProperty();
        private final SimpleStringProperty heatNumber = new SimpleStringProperty();
        private final SimpleStringProperty time = new SimpleStringProperty("");

        public HeatRow(String name, int heatNumber) {
            this.name.set(name);
            this.heatNumber.set("Heat " + heatNumber);
        }

        public String getName() { return name.get(); }
        public String getHeatNumber() { return heatNumber.get(); }
        public String getTime() { return time.get(); }

        public void setTime(String t) { time.set(t); }

        public SimpleStringProperty nameProperty() { return name; }
        public SimpleStringProperty heatNumberProperty() { return heatNumber; }
        public SimpleStringProperty timeProperty() { return time; }
    }
}
