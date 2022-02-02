/*This is the the class that handles the mechanics of the game:
 * Game constructor
 * guess function
 * printBoard function*/
import java.util.ArrayList;
public class Game{
	ArrayList<ArrayList<Character>> board;
	ArrayList<Character> code;
	ArrayList<Character> bank; //this will be filled with all the possible letters and the code will randomly grab from it
	private int pos;
	/*This constructor:
	 * assigns the ArrayLists above
	 * makes the main board by adding chars
	 * generates the secret code*/
	public Game(){
		pos = 0;
		board = new ArrayList<ArrayList<Character>>();
		//make board
		for(int i = 0; i<20;i++){
			board.add(new ArrayList<Character>());
			for(int k = 0; k<7;k++){

				if(i%2 != 0){
					
					if(k<4){
						board.get(i).add(' ');
					}else if(k>4){
						board.get(i).add('*');
					}else{
						board.get(i).add('	');
					}
				}else{
					if(k<4){
						board.get(i).add('?');
					}else if(k>4){
						board.get(i).add('*');
					}else{
						board.get(i).add('	');
					}
				}
			}
		}
		
		//generate code ArrayList
		bank = new ArrayList<Character>();
		bank.add('R');bank.add('Y');bank.add('O');bank.add('G');bank.add('B');bank.add('P');bank.add('W');
		code = new ArrayList<Character>();
		for(int i = 0; i<4; i++){//grab from the bank and remove it
			int rand = (int)(Math.random()* bank.size());
			code.add(bank.get(rand));
			bank.remove(rand);
		}
	}
	
	
	/*this guess function:
	 * takes in a string (the player's guess) and returns an int: 0=keep playing, 1=lose, 2=win
	 * puts the player guesses on the board
	 * checks to see if the guesses match with the code and randomly places the B and W indicator pins in the designated spots
	 * checks to see what number to return*/
	public int guess(String input){
		ArrayList<Character> guess = new ArrayList<Character>();
		ArrayList<Character> pins = new ArrayList<Character>();
		
		for(int i = 0; i<4;i++){
			guess.add(input.charAt(i)); //add player guess to board
			for(int k = 0; k<4; k++){
				if(guess.get(i) == code.get(k)){//add B and W pins accordingly
					if(k==i){
						pins.add('B');
					}else{
						pins.add('W');
					}
				}
			}
			board.get(pos).set(i, guess.get(i));
		}
		
		//these are for scrambling the order of the B and W pins
		ArrayList<Integer> unscrambled = new ArrayList<Integer>();
		unscrambled.add(0);unscrambled.add(1);unscrambled.add(2);unscrambled.add(3);
		ArrayList<Integer> scrambled = new ArrayList<Integer>();

		for(int i = 0; i<4; i++){
			int rand = (int)(Math.random()* unscrambled.size());
			scrambled.add(unscrambled.get(rand));
			unscrambled.remove(rand);
		}
		
		//places the scrambled pins in each possible position
		for(int i = 0; i<pins.size();i++){
			if(i == scrambled.get(0)){
				board.get(pos).set(5, pins.get(i));
			}else if(i== scrambled.get(1)){
				board.get(pos).set(6, pins.get(i));
			}
			else if(i== scrambled.get(2)){
				board.get(pos+1).set(5, pins.get(i));
			}else{
				board.get(pos+1).set(6, pins.get(i));
			}
		}
		
		pos+=2; //this shifts down the board so new guess are in lower rows, etc.
		unscrambled.add(0);unscrambled.add(1);unscrambled.add(2);unscrambled.add(3);
		printBoard();
		
		//check if game is over, win, lose, etc.
		int counter = 0;
		for(int i = 0; i<pins.size();i++){
			if(pins.get(i) == 'B'){
				counter++;
			}
		}
		if(counter == 4){
			return 2;//wins
		}
		counter = 0;
		if(pos == 20){
			return 1;//loses
		}
		
		return 0;//keep playing
	}
	
	//this printBoard function prints to board with dividers and also converts it to a string so I can take out all the brackets and commas
	public void printBoard(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(" BOARD:        PINS:");
		int counter = 0;
		System.out.println("---------------------");
		for(int i = 0; i<board.size();i++){//places dividers nicely
			if(counter ==2){
				System.out.println("---------------------");
				counter = -1;
				i--;
			}else{
				//get rid of brackets and commas
				String printBoard = board.get(i).toString()
				.replace(",", "")  
				.replace("[", "|")  
				.replace("]", "|")  
				.trim(); 
				System.out.println(printBoard);
			}
			counter++;
		}	
		System.out.println("---------------------");
	}
	
	
}

