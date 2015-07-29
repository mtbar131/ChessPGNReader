
public class MoveParser {
	
	ChessBoard updateChaessboard(ChessBoard currenrBoardState, String move, boolean isWhitesTurn){
		return new ChessBoard();
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
