# Mastermind

## How To Play:
  A computer will randomly generate a secret, 4 digit code. The goal of the player is to guess the code by guessing possible 4 letter combinations (the possible letters are RGBYWPO). Once the player guesses, B pins indicate if a letter is in the code and in the right place and W pins indicate if a letter is in the code but in the wrong place. The placement of the indicator pins are random. The player has 10 tries to guess the code or they lose. Letters do not repeat. Have fun!

## Status Update
Jan. 24...
  Today separated my code into a Tester and Game class. For the Tester, I made an inital UI and also allowed users to input a guess. In the Game class, I made a function 
  to nicely print out the board and also started to add guessing and feedback. 
Jan. 26...
  Added the pins but they arent truly random so i worked on that. I also added UI spacing to make it look nicer and I finished game continuation
Jan. 28...
  Fixed pins so they are random now
Feb. 1...
  Added instructions and replays. Also added a bunch of comments to finish. 

## What I Learned
  - got better at working with ArrayLists
  - worked more with String and Character functions
  - figured methods to randomize and assign things in ArrayLists

## Project Reflection
  At first I wondered how to handle the randomness of the game, but I figured I could use ArrayLists as "banks" to randomly grab from. From then on it was just thinking through the project. Still, making the pins randomly place was the part that took me the longest time, but I figured I could scramble the ArrayList of pins and then place them in order. It was interesting to work with String methods like .replace and .trim to make my board look nice and I also learned about Character.isLetter which checks if a char is a letter. Because of Lemonade Stand and Battleship, I had a feel of the workflow of the project which made it smooth sailing for the most part.
