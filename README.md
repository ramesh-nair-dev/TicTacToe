---

# 🎮 Tic Tac Toe – Advanced OOP Design

A classic **Tic Tac Toe game** reimagined with **scalable object-oriented design**, **design patterns**, and **bot AI strategies**.
This project demonstrates how even a simple game can be engineered like a professional software system.

---

## ✨ Features

* 👥 **Human vs Human** and **Human vs Bot** modes
* 🧠 **Bot with difficulty levels** (strategy-based AI)
* 🏆 **Winning Strategies:** Row, Column, Diagonal (extensible)
* 🏗️ **Clean OOP Architecture** – Players, Board, Moves, Game State
* 🎯 **Design Patterns Implemented:**

  * **Strategy Pattern** → Bot moves & Winning checks
  * **Factory Pattern** → Bot strategy selection
  * **Polymorphism & Enums** → Clean player and state handling
* 🔓 **Open/Closed Principle (OCP):**
  Add new bot difficulties or winning strategies **without modifying** existing code.

---

## 🏗️ Project Structure

```
src/
 ┣ Main.java                 # Entry point
 ┣ TicTacToe/
 ┃ ┣ controller/
 ┃ ┃ ┗ gameController.java   # Orchestrates the game flow
 ┃ ┣ models/
 ┃ ┃ ┣ Board.java            # Core board logic
 ┃ ┃ ┣ Game.java             # Game state and rules
 ┃ ┃ ┣ Player.java           # Abstract player
 ┃ ┃ ┣ HumanPlayer.java      # Human implementation
 ┃ ┃ ┣ BotPlayer.java        # Bot implementation
 ┃ ┃ ┣ BotLevel.java         # Enum for bot difficulty
 ┃ ┃ ┣ GameState.java        # Enum for game status
 ┃ ┃ ┣ Cell, Move, Symbol... # Supporting models
 ┃ ┣ strategy/
 ┃ ┃ ┣ WinningStrategy.java          # Interface
 ┃ ┃ ┣ RowWinningStrategy.java       # Row-based win
 ┃ ┃ ┣ ColWinningStrategy.java       # Column-based win
 ┃ ┃ ┣ DiagonalWinningStrategy.java  # Diagonal-based win
 ┃ ┃ ┣ BotPlayingStrategy.java       # Bot interface
 ┃ ┃ ┣ EasyBotPlayingStrategy.java   # Easy difficulty
 ┃ ┃ ┗ BotPlayingStrategyFactory.java# Factory for bot levels
```

---

## 🧩 Design Highlights

* 🔄 **Strategy Pattern:** Winning conditions & bot decisions are pluggable strategies.
* 🏭 **Factory Pattern:** Bot strategy chosen dynamically at runtime.
* 👥 **Polymorphism:** Human & Bot players share the same `Player` abstraction.
* ⚡ **Extensible:** Add `MediumBotPlayingStrategy` or `CustomWinningStrategy` without breaking existing code.
* 🧪 **Testability:** Modular design makes it easy to test individual components (Board, Player, Strategies).

---

## 🚀 Getting Started

### 1️⃣ Clone the repo

```bash
git clone https://github.com/your-username/TicTacToe.git
cd TicTacToe
```

### 2️⃣ Run the project

```bash
javac src/Main.java
java -cp src Main
```

---

## 🎯 Why This Project is Special

✅ Not just a Tic Tac Toe — it’s a **showcase of software craftsmanship**.
✅ Demonstrates **real-world OOP principles** (inheritance, abstraction, polymorphism).
✅ Highlights **design patterns** (Strategy, Factory, OCP) in action.
✅ Recruiters see **scalable thinking** beyond a toy project.
✅ Developers see **clean, extensible, fun code** to play with.

---

## 📌 Future Enhancements

* 🤖 Smarter bots (Minimax algorithm, Alpha-Beta pruning)
* 🌐 Multiplayer mode with networking
* 🖥️ GUI version (JavaFX or Swing)

---

## 👨‍💻 Author

**Ramesh Nair**
Software Engineer | OOP Enthusiast | Design Pattern Explorer

---


