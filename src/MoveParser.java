import java.util.ArrayList;
import java.util.Iterator;

public class MoveParser {

	public boolean isaChar(char ch){
		return (ch >= 'a') && (ch <= 'z');
	}

	public boolean isaDigit(char ch){
		return (ch >= '0') && (ch <= '9');
	}

	public String getFinalPosition(String move){

		int i = 0;
		while(!isaDigit(move.charAt(i))){
			i++;
		}

		return Character.toString(move.charAt(i - 1)) + Character.toString(move.charAt(i));

	}

	boolean matchesWithInput(String position, String input){
		return true;
	}

	ChessBoard updateChessboard(ChessBoard currentBoardState, String move, boolean isWhitesTurn){
		String piece;
		String newPosition = move;
		ArrayList<String> currentPositions;

		if(move.equals("O-O-O")){

		}
		else if(move.equals("O-O")){

		}

		if(move.charAt(0) >= 'A' && move.charAt(0) <= 'Z'){
			piece = Character.toString(move.charAt(0));
			newPosition = move.substring(1);
		}
		else
			piece = "P";

		if(isWhitesTurn){
			piece = "W" + piece;
		}
		else{
			piece = "B" + piece;
		}

		currentPositions = currentBoardState.getPositions(piece);
		newPosition = getFinalPosition(newPosition);
		String currPos = "";

		for (String positions : currentPositions){
			if(currentBoardState.isValidMove(positions, newPosition) &&
					matchesWithInput(positions, move)){
				currPos = positions;
			}
		}

		return currentBoardState.updateBoard(currPos, newPosition);
	}
	
	boolean isWhitesMoveFirst(String move) {
		int countOfDot = 0;
		for ( int i = 0; i < move.length(); i++ ) {
			if ( move.charAt(i) == '.' )
				countOfDot++;
		}
		return countOfDot == 1;
	}

	public static void main(String args[]){
		MoveParser mv = new MoveParser();
//		System.out.println(mv.getFinalPosition("Pe3"));
//		System.out.println(mv.getFinalPosition("f4"));
//		System.out.println(mv.getFinalPosition("Kxe1"));
//		System.out.println(mv.getFinalPosition("Ra6+"));
//		System.out.println(mv.getFinalPosition("Kaf6"));
	}
}
