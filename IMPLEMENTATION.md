# Implementation Manual: Mock Meet Trainer

## Overview

This application is a JavaFX-based desktop tool that allows swim coaches to simulate a mock swim meet for training purposes. It includes functionality to:
- Add and manage swimmers
- Generate events based on selected meet type
- Enter heat results for each swimmer
- Display a ranked leaderboard with calculated scores

The app is entirely implemented in Java and JavaFX, using object-oriented design principles such as encapsulation, inheritance, and polymorphism.

---

## Class Structure

### `Swimmer`
- **Purpose**: Represents a swimmer and their best times per event.
- **Fields**:
  - `StringProperty name`
  - `Map<String, String> bestTimes`
- **Key Methods**:
  - `getName()`, `setName()`, `nameProperty()`
  - `setBestTime(String event, String time)`
  - `getBestTime(String event)`

---

### `Event`
- **Purpose**: Represents a swim event with a name and a list of swimmers.
- **Fields**:
  - `String name`
  - `List<Swimmer> swimmers`
- **Key Methods**:
  - `getName()`, `addSwimmer(Swimmer s)`, `getSwimmers()`

---

### `PracticeType` (Enum)
- **Purpose**: Enum defining event sets for different meet types (`FREESTYLE`, `IM`, `STROKE`)
- **Fields**:
  - `String name`
  - `List<String> events`
- **Key Methods**:
  - `getEvents()`

---

### `SwimmerForm`
- **Purpose**: JavaFX UI pane to input and display swimmers in a `TableView`.
- **Fields**:
  - `List<Swimmer> swimmerDatabase`
  - `TableView<Swimmer> swimmerTable`
- **Key Methods**:
  - `getPane()`, `getSwimmerList()`

---

### `MeetGeneratorView`
- **Purpose**: UI to select a meet type and generate events using `PracticeType`.
- **Fields**:
  - `ComboBox<PracticeType> practiceTypeSelector`
  - `List<Event> generatedEvents`
- **Key Methods**:
  - `generateMeet(PracticeType type)`
  - `getEvents()`

---

### `HeatEntryView`
- **Purpose**: UI to select an event and enter race times per swimmer.
- **Fields**:
  - `ComboBox<String> eventSelector`
  - `TableView<HeatRow>`
  - `Map<String, List<HeatRow>> eventHeats`
- **Key Methods**:
  - `loadSelectedEventHeats(String eventName)`

---

### `LeaderboardView`
- **Purpose**: UI pane that displays leaderboard rankings and scores per swimmer.
- **Fields**:
  - `ListView<String> eventResultsList`
  - `TextArea totalScoresArea`
- **Key Methods**:
  - `updateLeaderboard()`

---

### `MainView` and `Main`
- **Purpose**: Wraps all the tabs together and starts the JavaFX application.

---

## Notable Implementation Features

- **Object-Oriented Design**: Every tab (Swimmer setup, Meet generator, Heat entry, Leaderboard) is implemented as a separate class with encapsulated logic.
- **JavaFX GUI**: Uses `VBox`, `HBox`, `ComboBox`, `TableView`, and styled buttons to build a cohesive UI.
- **Scoring Logic**: The leaderboard assigns points only for swimmers who have times entered, using race order to determine placement.

---

## Technologies Used

- Java 17
- JavaFX 21
- GitHub for version control
