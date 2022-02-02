/**
 * @author Daniel Yi
 * **/

/*this is the Tester class that handles the UI and player inputs:
 * main function
 * playGame function*/
import java.util.Scanner;
import java.util.ArrayList;
public class Tester{
	/*this main function:
	 * explains how to play
	 * calls playGame function to begin*/
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Hey Kids! Welcome to Mastermind!");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.println("HOW TO PLAY:");
		System.out.println("- Your job is to guess the 4 letter code set by your opponent.");
		System.out.println("- If you see a W pin on the right of the board, you know you have a correct letter but in the wrong order.");
		System.out.println("- If you see a B pin, you know you have a correct letter in the right order.");
		System.out.println("- The pin positions don't correspond to the order of the words.");
		System.out.println("- You have 10 tries to guess the code correctly. Letters do not repeat.");
		System.out.println("- Make sure to enter in valid letters to not waste turns");
		System.out.println("- PLEASE MAXIMIZE WINDOW FOR BEST EXPERIENCE");
		System.out.println("--------------------------------------------------------------------------------------------------------------");
		System.out.print("Press [Enter] to Play: ");
		scan.nextLine();
		playGame();
		
	}
	
	/*this playGame function:
	 * takes in a player guess and checks if it valid
	 * then it calls the Game class and passes in the player's guess
	 * if the player wins, loses, etc. then it prints accordingly and asks to play again*/
	public static void playGame(){
		Scanner scan = new Scanner(System.in);
		Game g = new Game();
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		int status = 0;
		g.printBoard();
		while(status == 0){//keeps going if keep playing: 1=lose, 2 = win
			Scanner scan2 = new Scanner(System.in);
			
			System.out.println("Possible Letters: R, O, Y, G, B, P, W");
			System.out.print("Input 4 Letters To Guess: ");
			String input = scan2.nextLine();
			//if not 4 letters
			if(input.length() != 4){
				g.printBoard();
				System.out.println("INPUT ERROR: Your code must be 4 letters long!!!");
			//if not a letter
			}else if(Character.isLetter(input.charAt(0)) == false || Character.isLetter(input.charAt(1)) == false || Character.isLetter(input.charAt(2)) == false || Character.isLetter(input.charAt(3)) == false){
				g.printBoard();
				System.out.println("INPUT ERROR: Letters only please!!!");
			}else{
				//even if the input is lower case, still work
				status = g.guess(input.toUpperCase());
			}
			
		}
		
		if(status == 1){
			System.out.println("OH NO! YOU RAN OUT OF GUESSES!! YOU LOSE!!");
			System.out.print("THE CODE WAS: ");
			System.out.println(g.code);
		}else{
			System.out.println("YAY! YOU WIN!");
		}
		
		System.out.print("\nPRESS [ENTER] TO PLAY AGAIN: ");
		scan.nextLine();
		playGame();
	}
}
