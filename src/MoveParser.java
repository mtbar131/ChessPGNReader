import java.util.ArrayList;


public class MoveParser {

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
		int i = 0;
		while(!isaDigit(input.charAt(i))){
			i++;
		}
		if(i == 2){
			return true;
		} else if(i == 3){
			if(input.charAt(i - 2) == 'x'){
				return true;
			}
			else if(position.charAt(0) == input.charAt(i - 2))
				return true;
		} else if(i == 4){
			if(input.charAt(i - 2) == 'x'){
				return input.charAt(i - 3) == position.charAt(0);
			}
			else
				return input.charAt(i - 3) == position.charAt(1) &&
						input.charAt(i - 4) == position.charAt(0);
		} else if(i == 5){
			return input.charAt(i - 3) == position.charAt(1) &&
					input.charAt(i - 4) == position.charAt(0);
		}
		return false;
	}

	boolean isaValidCapture(ChessBoard currBoard, String move, String finalPos){
		if(!currBoard.whichPiece(finalPos).equals("") && !move.contains(Character.toString('x')))
			return false;
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
					matchesWithInput(positions, move) &&
					isaValidCapture(currentBoardState, move, newPosition)){
				currPos = positions;
			}
		}

		if(move.contains(Character.toString('='))){
			String p;
			if(isWhitesTurn)
				p = "W";
			else
				p = "B";
			p = p + move.substring(move.indexOf('='), move.indexOf('=') + 1);
			currentBoardState.promotePawn(p, newPosition);
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

		System.out.println(mv.matchesWithInput("e3", "Ne3"));
		System.out.println(mv.matchesWithInput("f1", "Ne3"));
		System.out.println(mv.matchesWithInput("d1", "Nxe3"));
		System.out.println(mv.matchesWithInput("e3", "Nec3"));
		System.out.println(mv.matchesWithInput("a1", "Nfc3"));
		System.out.println(mv.matchesWithInput("a3", "Naxe3"));
		System.out.println(mv.matchesWithInput("e1", "Ne1xc3"));
	}
}
