import java.util.ArrayList;
public class Game{
	ArrayList<ArrayList<Character>> board;
	ArrayList<Character> code;
	ArrayList<Character> bank;
	private int pos;
	public Game(){
		pos = 0;
		board = new ArrayList<ArrayList<Character>>();
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
	public boolean guess(String input){
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
		
		ArrayList<Integer> unscrambled = new ArrayList<Integer>();
		unscrambled.add(0);unscrambled.add(1);unscrambled.add(2);unscrambled.add(3);
		ArrayList<Integer> scrambled = new ArrayList<Integer>();

		for(int i = 0; i<4; i++){
			int rand = (int)(Math.random()* unscrambled.size());
			scrambled.add(unscrambled.get(rand));
			unscrambled.remove(rand);
		}
		
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
		
		pos+=2;
		unscrambled.add(0);unscrambled.add(1);unscrambled.add(2);unscrambled.add(3);
		System.out.println(pins);
		printBoard();
		
		if(pos == 20){
			return false;
		}
		
		return true;
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

