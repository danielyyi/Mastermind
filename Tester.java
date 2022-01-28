import java.util.Scanner;
import java.util.ArrayList;
public class Tester{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("Hey Kids! Welcome to Mastermind!");
		System.out.print("Press [Enter] to Play: ");
		scan.nextLine();
		
		Game g = new Game();
		boolean playing = true;
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		while(playing){
			Scanner scan2 = new Scanner(System.in);
			
			System.out.println("Possible Pin Colors: R, O, Y, G, B, P, W");
			System.out.print("Input 4 Pin Colors To Guess: ");
			String input = scan2.nextLine();
			playing = g.guess(input);
		}
		g.printBoard();
	}
}
