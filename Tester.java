import java.util.Scanner;
import java.util.ArrayList;
public class Tester{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Hey Kids! Welcome to Mastermind!");
		System.out.print("Press [Enter] to Play: ");
		scan.nextLine();
		
		Game g = new Game();
		boolean playing = true;
		
		while(playing){
			Scanner scan2 = new Scanner(System.in);
			System.out.print("Type 4 letters as your guess (R, O, Y, G, B, P, W):");
			String input = scan2.nextLine();
			g.convert(input);
			g.printBoard();
		}
		
		
		
		g.printBoard();
	}
}
