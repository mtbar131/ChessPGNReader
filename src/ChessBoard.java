import java.util.ArrayList;
import java.util.HashMap;


public class ChessBoard {


	String[][] board; 

	HashMap<String, ArrayList<int[]>> possibleMoves=new HashMap <String, ArrayList<int[]>>();



	ChessBoard(){
		this.board = new String[][] {{"BR","BN","BB","BQ","BK","BB","BN","BR"},
				{"BP","BP","BP","BP","BP","BP","BP","BP"},
				{""  ,""  ,""  ,""  ,""  ,""  ,""  ,""  },
				{""  ,""  ,""  ,""  ,""  ,""  ,""  ,""  },
				{""  ,""  ,""  ,""  ,""  ,""  ,""  ,""  },
				{""  ,""  ,""  ,""  ,""  ,""  ,""  ,""  },
				{"WP","WP","WP","WP","WP","WP","WP","WP"},
				{"WR","WN","WB","WQ","WK","WB","WN","WR"}
		};

	}

	int[] sanToIndex(String SANposition) {
		int rowColIndex[] = new int[2];
		char file = SANposition.charAt(0);
		int rank = Integer.parseInt(Character.toString(SANposition.charAt(1)));
		rowColIndex[0] = 8 - rank;
		rowColIndex[1] = file - 'a';
		return rowColIndex;	
	}

	String indexToSan(int row,int column) {
		String file = Character.toString((char) ('a' + column));
		String rank = Integer.toString(8 - row);
		return file + rank;
	}

	ChessBoard updateBoard(String initialPosition, String finalPosition) {
		int[] initialIndex=sanToIndex(initialPosition);
		int[] finalIndex=sanToIndex(finalPosition);
		board[finalIndex[0]][finalIndex[1]]=board[initialIndex[0]][initialIndex[1]];
		board[initialIndex[0]][initialIndex[1]]="";
		return this;
	}

	String whichPiece(String position) {
		int[] positionIndex=sanToIndex(position);
		return board[positionIndex[0]][positionIndex[1]];
	}

	ArrayList<String> getPositions(String piece) {
		ArrayList<String> positions=new ArrayList<String>();
		for (int i=0;i<8;i++){
			for (int j=0;j<8;j++){
				if (board[i][j].equals(piece)){
					positions.add(indexToSan(i,j));
				}
			}
		}
		return positions;		
	}

	boolean isValidMove(String initialPosition, String finalPosition, boolean isCapture) {

		
		int[] initialIndex=sanToIndex(initialPosition);
		int[] finalIndex=sanToIndex(finalPosition);
		String piece=board[initialIndex[0]][initialIndex[1]];

		int rowDiffAbs=Math.abs(finalIndex[0]-initialIndex[0]);
		int columnDiffAbs=Math.abs(finalIndex[1]-initialIndex[1]);

		if (piece.equals("WP")||piece.equals("BP")){
			if(rowDiffAbs == 2 && columnDiffAbs == 0)
				return true;
			else if(rowDiffAbs==1 && columnDiffAbs==0)
				return true;
			else if(rowDiffAbs == 1 && columnDiffAbs==1 && isCapture)
				return true;
			return false;
		}
		
		if (piece.equals("WK")||piece.equals("BK")){
			if ((rowDiffAbs==0 && columnDiffAbs==1) || (rowDiffAbs==1 && columnDiffAbs==0) ||
					(rowDiffAbs==1 && columnDiffAbs==1))				
			{
				return true;
			}
		}
		
		if (piece.equals("WB")||piece.equals("BB")) {
			if (rowDiffAbs==columnDiffAbs) {
				return true;
			}
		}
		
		if (piece.equals("WR")||piece.equals("BR")) {
			if ((rowDiffAbs==0 && columnDiffAbs>0)||(rowDiffAbs>0 && columnDiffAbs==0)){
				return true;
			}
		}
		
		if(piece.equals("WQ")||piece.equals("BQ"))
		{
			if ((rowDiffAbs==columnDiffAbs)||
					(rowDiffAbs==0 && columnDiffAbs>0)||(rowDiffAbs>0 && columnDiffAbs==0)) {
				return true;
			}
		}
			
		if (piece.equals("WN")||piece.equals("BN")) {
			if ((rowDiffAbs==2 && columnDiffAbs==1)||(rowDiffAbs==1 && columnDiffAbs==2)){
				return true;
			}
		}
		
		return false;
	}

	void printChessboard() {
		for(int i=0;i<8;i++)
		{
			System.out.print(8 - i);
			for(int j=0;j<8;j++)
			{
				if(!board[i][j].equals(""))
				{
					System.out.print(" " + board[i][j] + " ");
				}
				else {
					System.out.print("    ");
				}
			}
			System.out.println();
		}
		System.out.println("  a   b   c   d   e   f   g   h");
	}

	ChessBoard promotePawn(String piece, String postion){

		int[] positionIndex=sanToIndex(postion);
		board[positionIndex[0]][positionIndex[1]]=piece;	
		return this;

	}

}
