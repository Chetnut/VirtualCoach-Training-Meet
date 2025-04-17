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

Swimmer.java
This class is for making swimmer objects. Each swimmer has a name and a list of their best times.
--
Event.java
This class represents a swim event, like “50 Free” or “100 IM.” Each event has a name and a list of swimmers who are racing in it.
--
PracticeType.java
This is an enum that stores different types of meets: Freestyle, IM, and Stroke. Each type has a list of events that match that type.
--
SwimmerForm.java
This is the screen where you add swimmers. You type in a name, click a button, and it shows up in a table.
--
MeetGeneratorView.java
This screen lets you choose a meet type (freestyle, IM, stroke) and generates events using the swimmers you added.
--
HeatEntryView.java
This screen shows the events and lets you enter each swimmer’s time for their race.
--
LeaderboardView.java
This screen shows who scored points and keeps track of the total scores for all swimmers.
--
MainView.java
This connects all the screens (tabs) together so the app has multiple tabs for swimmer setup, meet generation, heat entry, and leaderboard.
--
