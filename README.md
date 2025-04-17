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

## User Manual

The VirtualCoach Training Meet app is a desktop application designed to help swim coaches create practices that resemble a meet an foster competition between the swimmers. The app allows you to:

1. **Add Swimmers**
2. **Generate Meet Events** based on a practice type
3. **Enter Heat Times**
4. **View Leaderboard Results** with scores

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

---

### How to Use the Application

Click between 4 tabs: Swimmer Setup, Meet Generator, Heat Entry, and Leaderboard to navigate through the app and organize your meet-like practices.

In swimmer setup, you can add swimmers names to a list that will be used to set up heats when the events are generated.
In Meet Generator, you can choose between three types of practices: a Freestyle, IM, or Stroke foucus, which will determine the events that are swum. Then you can press generate to create the heats for each.
In Heat Entry, you can see what heats have been generated and input times that you would have taken in real life under each swimmer.
Finally, in Leaderboard, you can see the overall results by time of each event and a leaderboard that calculates a score based on the placement of a swimmer in each event.






