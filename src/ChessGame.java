import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ChessGame {

	private ChessBoard board;
	private MoveParser moveParser;
	
	ChessGame() {
		this.board = new ChessBoard();
		this.moveParser = new MoveParser();
	}
	
	void processPGN(String PGN_filepath) {
		try {
			Pattern moveStringPattern = Pattern.compile("\\d+[.]{1,3} +[a-h0-8KQRNBPOx#+=-]+ +[a-h0-8KQRNBPOx#+=-]+");
			
			Scanner fileReader = new Scanner(new File(PGN_filepath));
			while( fileReader.hasNextLine() ) {
				String pgnLine = fileReader.nextLine();
				
				if(pgnLine.trim().startsWith("[")){
					System.out.println(pgnLine);
				}
				else {
					Matcher matcher = moveStringPattern.matcher(pgnLine);
					while ( matcher.find() ){
						String move[] = matcher.group().split(" +");
						System.out.println("<< MOVE : " + Arrays.deepToString(move) + " >>");
						boolean isWhitesMoveFirst = moveParser.isWhitesMoveFirst(move[0]);
						
						System.out.println("################  CHESSBOARD STATE ################");
						board = moveParser.updateChessboard(board, move[1], isWhitesMoveFirst);
						board.printChessboard();
						System.out.println("---------------------------------------------------");
						board = moveParser.updateChessboard(board, move[2], !isWhitesMoveFirst);
						board.printChessboard();
						System.out.println("################  CHESSBOARD STATE ################");
					}
					if ( pgnLine.contains("0-1") ){
						System.out.println("BLACK wins the match");
					}
					else if ( pgnLine.contains("1-0") ) {
						System.out.println("WHITE wins the match");
					}
					else if ( pgnLine.contains("1/2-1/2")) {
						System.out.println("The match was a draw");
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("PGN file cannot be read.");
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		String FILEPATH = "./src/pgn_sample2.txt";
		//String FILEPATH = "C:\\Users\\test\\Documents\\BootCamp\\pgn_sample.txt";
		ChessGame game = new ChessGame();
		game.processPGN(FILEPATH);
	}
}
