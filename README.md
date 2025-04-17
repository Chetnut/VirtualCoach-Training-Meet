# VirtualCoach-Training-Meet
## Carson's Team
#### Team Members
Carson Ricker
## Pre-Project Idea Summary
The VirtualCoach Training Meet app is designed to streamline the process of organizing and managing swim meets for the purpose of training for coaches of all level. 
The application allows users to register swimmers, assign them to events and heats, and track results in a streamlined package.

This project was insired by personal experience as a member of a college swim team, having helped in run a few meets in the past. The app is based off the existing professional software, MeetManager, which provides a more extensive and detailed approach to directing a meet. The intent of this project is to create a more user-friendly, barebones version of the software that allows less those less experienced in MeetManager to set up swim meets. This should allow coaches of all levels to easily design "mock meets" to use as a training tool, without needing to bring in outside assistance if they are unfamiliar with the more complex software. 
## Initial UML Class Diagram
![image](https://github.com/user-attachments/assets/fb040abd-3b49-4017-90a5-511ca9eb3758)

## 🧑‍🏫 User Manual

The **Mock Meet Trainer** is a desktop application designed to help swim coaches create mock practice meets. The app allows you to:

1. **Add Swimmers**
2. **Generate Meet Events** based on a practice type
3. **Enter Heat Times**
4. **View Leaderboard Results** with auto-calculated scores

---

### 🔹 How to Use the Application

#### 1. Swimmer Setup Tab
- Enter a swimmer’s name in the text box and click **"Add"**.
- The swimmer will appear in the table below.
- You may add as many swimmers as you want before generating a meet.

#### 2. Meet Generator Tab
- Select a **Practice Type**: `FREESTYLE`, `IM`, or `STROKE`.
- Click **"Generate Meet"** to auto-create events based on the selected type.
- All registered swimmers will be entered into each event.
- The event list below displays each event and how many swimmers are in it.

#### 3. Heat Entry Tab
- Click the **"Load Events"** button to populate the dropdown with event names.
- Select an event from the dropdown.
- A table will appear with each swimmer and their assigned heat.
- Click **"Enter Time"** for each swimmer to input their result.
- Entered times will auto-save and be used for leaderboard scoring.

#### 4. Leaderboard Tab
- Click **"Refresh Leaderboard"** to update the results.
- The leaderboard shows:
  - Sorted finish order for each event
  - Total points for each swimmer across all events
- Only swimmers with entered times will be included in scoring.

---

### 🛠️ System Requirements

- Java 17 or higher
- JavaFX SDK (linked via `--module-path` in your `launch.json` or project settings)

---

### ▶️ How to Run

1. Clone this repository
2. Open the project in VS Code or your preferred Java IDE
3. Ensure your JavaFX libraries are properly set up
4. Run `Main.java`

