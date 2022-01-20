import java.util.ArrayList;

public class Tester{
	public static void main(String args[]){
		ArrayList<ArrayList<Character>> board = new ArrayList<ArrayList<Character>>();

		for(int i = 0; i<10;i++){
			board.add(new ArrayList<Character>());
			for(int k = 0; k<9;k++){
				if(k<4){
					board.get(i).add('?');
				}else if(k>4){
					board.get(i).add('O');
				}else{
					board.get(i).add('	');
				}
			}
		}

		System.out.print("   BOARD:");
		System.out.println("           SCORE:");
		for(int i = 0; i<board.size();i++){
			System.out.println(board.get(i));
		}
	}
}
