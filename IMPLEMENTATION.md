## Implementation Manual

This app is called VirtualCoach Training Meet. It was made using Java and JavaFX. The purpose is to help swim coaches run practice meets more easily by letting them manage swimmers, create events, record results, and view a scoreboard.
The app was built using object-oriented programming. Each part of the app (like swimmer setup, meet generation, results, and leaderboard) is handled in its own class file. This makes the code easier to organize and update.

#### Main features:

Swimmers can be added and stored in a list
Coaches can pick a meet type (freestyle, IM, or stroke)
The app generates events and assigns swimmers to heats
Coaches enter race times
The leaderboard shows who scored points in each event

#### Creation:

Each screen in the app was created using JavaFX layouts like VBox and HBox, and has buttons, tables, dropdowns, and labels. All the styling (like colors and font sizes) was done in Java code using setStyle().
The app uses Java 17 and JavaFX 21. All files are stored here in this GitHub repo.

#### Class Files Explanation

Swimmer – has a name (StringProperty) and a map of bestTimes that connects event names to time strings (Map<String, String>).

Event – has a name (String) and a list of swimmers (List<Swimmer>).

PracticeType – an enum with three choices: FREESTYLE, IM, STROKE. Each one has a name and a list of event names (List<String>).

SwimmerForm – has a VBox layout (root), a static list of swimmers (List<Swimmer>), and a TableView that shows swimmer data.

MeetGeneratorView – has a VBox layout (root), a ComboBox to choose practice type, a ListView to show generated events, and a static list of all created Event objects.

HeatEntryView – has a VBox layout (root), a ComboBox to choose an event, a TableView to show swimmers and heat numbers, and a map that connects each event name to its list of heat rows (Map<String, List<HeatRow>>).

LeaderboardView – has a VBox layout (root), a ListView that shows results for each event, and a TextArea that shows the total scores.

MainView – has a TabPane (with one tab for each of the above views) and loads all views into tabs.

Main – calls MainView and starts the whole app in a JavaFX window.
