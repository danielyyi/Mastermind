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
	public void convert(String input){
		ArrayList<Character> guess = new ArrayList<Character>();
		for(int i = 0; i<4;i++){
			guess.add(input.charAt(i));
		}
		
		for(int i = 0; i<4;i++){
			board.get(pos).set(i, guess.get(i));
			
			if(guess.get(i) == code.get(i)){
				if(board.get(pos).get(5) == '*'){
					board.get(pos).set(5, 'W');
				}else{
					if(board.get(pos).get(6) == '*'){
						board.get(pos).set(6, 'W');
					}else{
						if(board.get(pos+1).get(5) == '*'){
							board.get(pos+1).set(5, 'W');
						}else{
							board.get(pos+1).set(6, 'W');
						}
					}
				}
			}else{
				if(board.get(pos).get(5) == '*'){
					board.get(pos).set(5, 'B');
				}else{
					if(board.get(pos).get(6) == '*'){
						board.get(pos).set(6, 'B');
					}else{
						if(board.get(pos+1).get(5) == '*'){
							board.get(pos+1).set(5, 'B');
						}else{
							board.get(pos+1).set(6, 'B');
						}
					}
				}
			}
			
		}
		
	}
	public void printBoard(){
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
		System.out.println(code);
	}
	
	
}
