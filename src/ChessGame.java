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
			Pattern moveStringPattern = Pattern.compile("\\d+[.]{1,3} +[a-h0-8KQRNBPOx#-+=/]+ +[a-h0-8KQRNBPOx#-+=/]+");
			Scanner fileReader = new Scanner(new File(PGN_filepath));
			while( fileReader.hasNextLine() ) {
				Matcher matcher = moveStringPattern.matcher(fileReader.nextLine());
				while ( matcher.find() ){
					String move[] = matcher.group().split(" ");
					System.out.println(Arrays.deepToString(move));
					boolean isWhitesMoveFirst = moveParser.isWhitesMoveFirst(move[0]);
					board = moveParser.updateChessboard(board, move[1], isWhitesMoveFirst);
					System.out.println("################  CHESSBOARD STATE ################");
					board.printChessboard();
					board = moveParser.updateChessboard(board, move[2], !isWhitesMoveFirst);
					System.out.println("---------------------------------------------------");
					board.printChessboard();
					System.out.println("################  CHESSBOARD STATE ################");
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("PGN file cannot be read.");
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		//String FILEPATH = "./src/pgn_sample.txt";
		String FILEPATH = "C:\\Users\\test\\Documents\\BootCamp\\pgn_sample.txt";
		ChessGame game = new ChessGame();
		game.processPGN(FILEPATH);
	}
}
