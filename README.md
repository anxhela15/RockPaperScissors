# Rock-Paper-Scissors Game

This project is a console-based implementation of the classic **Rock-Paper-Scissors** game, designed using Java. It allows a human player to compete against a computer in a multi-round game, with outcomes displayed after each round.

## Features

- **Interactive Gameplay**: Human players can select their moves, while the computer chooses randomly.
- **Multi-Round Play**: The number of rounds can be specified by the user.
- **Score Tracking**: The game tracks and displays scores at the end.
- **Object-Oriented Design**: Clean separation of concerns using classes for players, hands, and game logic.

---

## Frameworks and Libraries Used

### 1. **JUnit 5 (JUnit Jupiter)**

**Value Added:**
- Allows us to write unit tests for all components (e.g., `RpsGame`, `HandFactory`, `HumanPlayer`, etc.).
- Provides assertions to validate expected outcomes.

### 2. **Mockito**

**Value Added:**
- Enables testing components like `IOProvider` in isolation by mocking its methods.
- Provides annotations like `@Mock` and `@InjectMocks` for a cleaner and more maintainable test setup.
- Verifies the interaction between classes, ensuring proper collaboration.

---

## How to Build and Run

### Prerequisites
- Java 17 or higher
- Maven 3.8.0 or higher

### Steps
1. Build the project using Maven:
   ```bash
   mvn clean install

2. Run the game:
   ```bash
   java -cp target/RockPaperScissors-1.0.jar org.rps.Main

## Testing
1. To run the test suite:
   ```bash
   mvn test

## Design Considerations

The design follows the Open/Closed Principle, ensuring the system is open to extension but closed to modification. To add new hands (e.g., "Lizard" or "Spock"):

- Extend AbstractHand: Create a new class (e.g., Lizard) to represent the new hand.
- Add Rules in a Custom HandFactory: Override HandFactory to define interactions between the new hand and existing hands.
- Initialize a New Game: Extend TwoPlayerGame to integrate the updated HandFactory.

## Why Maven?
Maven simplifies dependency management and project building. With Maven:

- Dependencies like JUnit and Mockito are easily added and maintained.
- Tests and builds are integrated into a unified process.

