# Text Adventure Game – CS6402 Assignment 1

Objective
Create a dialogue-based text adventure game that:
- Validates user input using regular expressions
- Guides the player through 4 interactive scenarios
- Offers multiple choices and branching outcomes
- Includes win/loss logic, replay options, and user feedback

Game Structure

1. Start
- Prompts the player to enter a name (2–15 characters, only letters, numbers, or underscores).
- Validates name using regex.

2. Scenario 1: The Forest
- Presents a scenario where the player is lost in a forest and chooses what to do next.
- All choices continue the game.

3. Scenario 2: The Stranger
- Encounter with a stranger. Choices lead to:
  - 70% chance to be saved
  - 30% chance to die
  - Continue the journey or play a game

4. Scenario 3: The River
- Cross a river by swimming, wading, or building a raft.
  - Swim = death (Sad End)
  - Others = saved (Happy End)

5. Scenario 4: The Guessing Game
- Guess a number between 1 and 10 (3 tries).
- Hints given after incorrect guesses.
- Success = saved; failure = death

6. Replay Prompt
- Asks the user: “Do you want to play again? (Y/N)”

   ```


