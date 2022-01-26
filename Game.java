import java.util.ArrayList;
public class Game{
	ArrayList<ArrayList<Character>> board;
	ArrayList<Character> code;
	ArrayList<Character> bank;
	ArrayList<Integer> scrambled;
	ArrayList<Integer> unscrambled;
	private int pos;
	public Game(){
		pos = 0;
		board = new ArrayList<ArrayList<Character>>();
		unscrambled = new ArrayList<Integer>();
		unscrambled.add(0);unscrambled.add(1);unscrambled.add(2);unscrambled.add(3);
		scrambled = new ArrayList<Integer>();
		//make board------------------------------------------
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
		//----------------------------------------------------
		
		//make code board-------------------------------------
		bank = new ArrayList<Character>();
		bank.add('R');bank.add('Y');bank.add('O');bank.add('G');bank.add('B');bank.add('P');bank.add('W');
		code = new ArrayList<Character>();
		for(int i = 0; i<4; i++){
			int rand = (int)(Math.random()* bank.size());
			code.add(bank.get(rand));
			bank.remove(rand);
		}
		//----------------------------------------------------
	}
	public void convert(String input){
		ArrayList<Character> guess = new ArrayList<Character>();
		ArrayList<Character> pins = new ArrayList<Character>();
		
		for(int i = 0; i<4;i++){
			guess.add(input.charAt(i));
			for(int k = 0; k<4; k++){
				if(guess.get(i) == code.get(k)){
					if(k==i){
						pins.add('B');
					}else{
						pins.add('W');
					}
				}
			}
			board.get(pos).set(i, guess.get(i));
		}
		ArrayList<Integer> copy = unscrambled;
		for(int i = 0; i<4; i++){
			int rand = (int)(Math.random()* (4-i));
			scrambled.add(copy.get(rand));
			copy.remove(rand);
		}
		
		
		for(int i = 0; i<pins.size();i++){
			if(i == scrambled.get(0)){
				board.get(pos).set(5, pins.get(0));
			}else if(i== scrambled.get(1)){
				board.get(pos).set(6, pins.get(1));
			}
			else if(i== scrambled.get(2)){
				board.get(pos+1).set(5, pins.get(2));
			}else{
				board.get(pos+1).set(6, pins.get(3));
			}
		}
		
		
		System.out.println(pins);
		printBoard();
		
		pos+=2;
		
	}
	public void printBoard(){
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println(" BOARD:        SCORE:");
		int counter = 0;
		System.out.println("---------------------");
		for(int i = 0; i<board.size();i++){
			if(counter ==2){
				System.out.println("---------------------");
				counter = -1;
				i--;
			}else{
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
