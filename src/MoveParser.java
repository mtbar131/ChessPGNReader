import java.util.ArrayList;


public class MoveParser {

	public boolean isaDigit(char ch){
		return (ch >= '0') && (ch <= '9');
	}

	public String getFinalPosition(String move){

		int i = move.length() - 1;
		while(!isaDigit(move.charAt(i))){
			i--;
		}

		return Character.toString(move.charAt(i - 1)) + Character.toString(move.charAt(i));

	}

	boolean matchesWithInput(String position, String input){
		int i = 0;
		if(input.length() < 6) {
			while (!isaDigit(input.charAt(i))) {
				i++;
			}
			if (i == 1 || i == 2) {
				return true;
			} else if (i == 3) {
				if (input.charAt(i - 2) == 'x') {
					return true;
				} else if (position.charAt(0) == input.charAt(i - 2))
					return true;
			} else if (i == 4) {
				if (input.charAt(i - 2) == 'x') {
					return input.charAt(i - 3) == position.charAt(0);
				} else
					return input.charAt(i - 3) == position.charAt(1) &&
							input.charAt(i - 4) == position.charAt(0);
			} else if (i == 5) {
				System.out.printf("In i 5" + input + " " + position);
				return input.charAt(i - 3) == position.charAt(1) &&
						input.charAt(i - 4) == position.charAt(0);
			}
		}
		else {
			return input.charAt(1) == position.charAt(0) &&
					input.charAt(2) == position.charAt(1);
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

		if(move.equals("O-O")){

			if(isWhitesTurn)
			{
				currentBoardState.updateBoard("e1","g1");
				currentBoardState.updateBoard("h1", "f1");

			}
			else{
				currentBoardState.updateBoard("e8","g8");
				currentBoardState.updateBoard("h8", "f8");
			}
			
		}
		else if(move.equals("O-O-O")){
			if(isWhitesTurn)
			{
				currentBoardState.updateBoard("e1","c1");
				currentBoardState.updateBoard("a1", "d1");

			}
			else{
				currentBoardState.updateBoard("e8","c8");
				currentBoardState.updateBoard("a8", "d8");
			}
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

			if(currentBoardState.isValidMove(positions, newPosition , move.contains(Character.toString('x'))) &&
					matchesWithInput(positions, move) &&
					isaValidCapture(currentBoardState, move, newPosition)){
				System.out.println(matchesWithInput(positions, move));
				System.out.println(isaValidCapture(currentBoardState, move, newPosition));
				System.out.println(positions+"|"+newPosition+"|"+move);
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

		if(currPos.length() > 0)
			return currentBoardState.updateBoard(currPos, newPosition);
		else{
			System.out.println("New position is not valid");
			return currentBoardState;
		}
	}
	
	boolean isWhitesMoveFirst(String move) {
		int countOfDot = 0;
		for ( int i = 0; i < move.length(); i++ ) {
			if ( move.charAt(i) == '.' )
				countOfDot++;
		}
		return countOfDot == 1;
	}

}
