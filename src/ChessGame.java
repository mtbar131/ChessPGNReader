
public class ChessGame {

	private ChessBoard board;
	private MoveParser moveParser;
	
	ChessGame() {
		this.board = new ChessBoard();
		this.moveParser = new MoveParser();
	}
	
	void processPGN(ChessBoard initialBoardState, String PGN_filepath) {
		
	}
}
