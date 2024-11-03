# AmongSanCle Game

AmongSanCle is a command-line game inspired by *Among Us*, where players take on the roles of students and impostors. Players are assigned tasks within different rooms, and impostors aim to sabotage them by eliminating students. The game includes a structured menu system that allows players to manage tasks, view player details, and set game configurations.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Classes](#classes)
- [Menu Structure](#menu-structure)
- [Getting Started](#getting-started)
- [Usage](#usage)
- [Example Gameplay](#example-gameplay)
- [License](#license)

## Overview

In AmongSanCle, players can be either **Students** who complete tasks or **Impostors** who aim to disrupt the game by eliminating students. Each round has a set of tasks, a maximum response time, and a specified number of impostors. The game structure is based on a menu-driven system, allowing for easy navigation and action execution.

## Features

- **Player Roles**: Players are assigned as either students or impostors. Impostors have unique abilities, such as eliminating students.
- **Task Management**: Each student receives a queue of tasks, which they complete to progress in the game.
- **Dynamic Menu System**: The game offers a nested menu system, allowing users to add players, set configurations, view player and task details, and control gameplay.
- **Singleton Input Handling**: A `SingletonScanner` ensures a single, shared instance for handling user input throughout the game.

## Classes

The core classes and their functionalities:

1. **Estudiante** (`Estudiante.java`): Represents a student player with a set of tasks to complete.
2. **Impostor** (`Impostor.java`): Represents an impostor player who can eliminate students and has its own task list.
3. **Jugador** (`Jugador.java`): Abstract base class representing a generic player with an alias and a queue of tasks.
4. **Tarea** (`Tarea.java`): Represents a task with a specific name and room, assigned to players.
5. **SingletonScanner** (`SingletonScanner.java`): Implements a singleton scanner instance for unified input handling.
6. **Ronda** (`Ronda.java`): Manages the game round, overseeing players, impostors, tasks, and overall game progression.

### Menu System

The game includes a structured menu system in the `Menu` package, allowing players to perform actions like adding or removing players, viewing tasks, and setting configurations:

- **Menu** (`Menu.java`): Base menu class allowing for hierarchical menu navigation.
- **ComponenteMenu** (`ComponenteMenu.java`): Abstract class representing a menu component, including execution logic.
- **AñadirJugador** (`AñadirJugador.java`): Adds a new player to the game round.
- **BorrarJugador** (`BorrarJugador.java`): Deletes a player from the game round.
- **VerJugadores** (`VerJugadores.java`): Displays a list of current players.
- **AñadirTarea** (`AñadirTarea.java`): Adds a new task to the game.
- **BorrarTarea** (`BorrarTarea.java`): Removes a task from the game.
- **VerTareas** (`VerTareas.java`): Displays a list of tasks.
- **TiempoMaximoRespuesta** (`TiempoMaximoRespuesta.java`): Configures the maximum response time allowed for tasks.
- **Jugar** (`Jugar.java`): Starts the game round.

## Menu Structure

The menu system is organized hierarchically and accessed from the main menu:

- **AmongSanCle (Main Menu)**
  - **Configuration**
    - **Players**: Add, view, or delete players.
    - **Tasks**: Add, view, or delete tasks.
    - **Max Response Time**: Set the maximum response time for tasks.
  - **Play**: Starts the gameplay loop.

## Getting Started

### Prerequisites

- **Java Development Kit (JDK) 8 or higher**

## Usage

1. **Navigate the Menu**: Use numeric options to navigate and select actions within the menu.
2. **Add Players and Tasks**: Use the configuration menu to add players and assign tasks.
3. **Set Game Configurations**: Adjust the maximum response time as desired.
4. **Start Gameplay**: Select “Play” to begin the round, where students work on tasks and impostors attempt to disrupt.

## Example Gameplay

```
Main Menu - AmongSanCle
-----------------------
1. Configuration
2. Play
Select an option: 2

Round 1
Student Maria is working on 'Clean the reactor in Reactor'
Impostor Pablo is trying to eliminate players in the same room...
Maria was eliminated by an impostor!
...
Game Over - The impostors won!
```