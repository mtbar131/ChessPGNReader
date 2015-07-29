import java.util.ArrayList;


public class ChessBoard {


	String[][] board; 
	
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
	
	int[] sanToIndex(String position)
	{
		return null;
		
	}
	
	String indexToSan(int i,int j)
	{
		return null;
	}
	
	ChessBoard updateBoard(String initialPosition, String finalPosition) {
		return new ChessBoard();
	}
	
	ChessBoard updateChessBoard(String move)
	{	
		return null;
	}
	
	String whichPiece(String position){
		int[] positionIndex=sanToIndex(position);
		return board[positionIndex[0]][positionIndex[1]];
	}
	
	ArrayList<String> getPositions(String piece) {
		
		ArrayList<String> positions=new ArrayList<String>();
		for(int i=0;i<8;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(board[i][j]==piece)
				{
					positions.add(indexToSan(i,j));
				}
			}
		}
		return positions;		
	}
	
	boolean isValidMove(String initialPosition, String finalPosition) {
		return true;
	}
	
	void printChessboard() {
		
	}
	
	
}
