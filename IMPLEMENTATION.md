🛠️ Implementation Manual: Mock Meet Trainer
Overview
This application is written entirely in Java using JavaFX and follows an object-oriented design. It includes multiple custom classes and GUI views for managing swimmers, generating mock swim meets, entering heat times, and displaying a ranked leaderboard.

1. Class Structure & Relationships
Refer to the included UML diagram for full structure.

SwimmerForm.java

Collects and displays a list of swimmers.

Uses JavaFX TableView to bind swimmer names via StringProperty.

Swimmer.java

Simple model class with StringProperty name and a Map<String, String> for storing best times by event.

PracticeType.java

Enum with predefined meet types (FREESTYLE, IM, STROKE) and their corresponding event names.

MeetGeneratorView.java

Handles user selection of practice type.

Generates a List<Event> based on the selection and assigns all swimmers to each event.

Event.java

Represents an individual swim event.

Holds a list of assigned swimmers and provides access to them for heat generation or scoring.

HeatEntryView.java

Lets the coach enter times for each swimmer in each event.

Uses a custom nested class HeatRow to track swimmer name, heat number, and entered time.

LeaderboardView.java

Displays event-by-event rankings and overall swimmer scores.

Scores only swimmers with valid times.

MainView.java

Main application tab layout combining all views.

Sets the JavaFX TabPane and organizes navigation between views.

Main.java

Launches the application and displays the main view.

2. Design Considerations
JavaFX Styling: The UI uses consistent setStyle() calls in Java to apply padding, button color, and layout without external CSS.

Data Sharing: Shared state like swimmer and event lists are passed via static methods (e.g., SwimmerForm.getSwimmerList()) to maintain a simple flow across multiple tabs.

Scoring Logic: Leaderboard skips scoring if no time was entered, ensuring fair and realistic practice scoring.

3. Challenges
Handling UI layout consistently across all views in JavaFX without FXML or CSS required careful use of VBox/HBox and style properties.

Synchronizing data across tabs required central static storage patterns rather than full MVC.

Ensuring times were properly saved and retrieved across different views required debugging and test cases.

4. How It Aligns with Project Goals
✅ Uses JavaFX GUI with multiple scenes.

✅ Applies inheritance and object-oriented design.

✅ Implements loops, conditions, lists, and event-driven programming.

✅ Demonstrates a real-world solution for swim coaching use.
