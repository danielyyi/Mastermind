# Mastermind
5pts - Github Readme File - Update, edit the readme file to desribe the project, add tules or play, and share a little about the evolving process of YOUR software development through this project.  In addition. -add a paragraph to take some time to share with me high and lows, stretches, or frustrations - etc.

##Project Reflection
  At first I wondered how to handle the randomness of the game, but I figured I could use ArrayLists as "banks" to randomly grab from. From then on it was just thinking through the project. Still, making the pins randomly place was the part that took me the longest time, but I figured I could scramble the ArrayList of pins and then place them in order. It was interesting to work with String methods like .replace and .trim to make my board look nice and I also learned about Character.isLetter which checks if a char is a letter. Because of Lemonade Stand and Battleship, I had a feel of the workflow of the project which made it smooth sailing for the most part.
  
##How To Play:
  A computer will randomly generate a secret, 4 digit code. The goal of the player is to guess the code by guessing possible 4 letter combinations (the possible letters are RGBYWPO). Once the player guesses, B pins indicate if a letter is in the code and in the right place and W pins indicate if a letter is in the code but in the wrong place. The placement of the indicator pins are random. The player has 10 tries to guess the code or they lose. Letters do not repeat. Have fun!
