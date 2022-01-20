import java.util.ArrayList;

public class Tester{
	public static void main(String args[]){
		ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>();
		for(int i = 0; i<20;i++){
			board.add(new ArrayList<Character>());
			for(int k = 0; k<7;k++){

				if(i%2 != 0){
					
					if(k<4){
						board.get(i).add(' ');
					}else if(k>4){
						board.get(i).add('O');
					}else{
						board.get(i).add('	');
					}
				}else{
					if(k<4){
						board.get(i).add('?');
					}else if(k>4){
						board.get(i).add('O');
					}else{
						board.get(i).add('	');
					}
				}
			}
		}

		System.out.print("   BOARD:");
		System.out.println("           SCORE:");
		
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
