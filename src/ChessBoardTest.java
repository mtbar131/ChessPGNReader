import static org.junit.Assert.*;

import org.junit.Test;


public class ChessBoardTest {

	@Test
	public void testSanToIndex() {
		ChessBoard board = new ChessBoard();
		int[] expectedOutput = new int[2];
		
		expectedOutput[0] = 0; expectedOutput[1] = 0;
		assertArrayEquals(expectedOutput, board.sanToIndex("a8"));
		
		expectedOutput[0] = 7; expectedOutput[1] = 0;
		assertArrayEquals(expectedOutput, board.sanToIndex("a1"));
		
		expectedOutput[0] = 0; expectedOutput[1] = 7;
		assertArrayEquals(expectedOutput, board.sanToIndex("h8"));
		
		expectedOutput[0] = 7; expectedOutput[1] = 7;
		assertArrayEquals(expectedOutput, board.sanToIndex("h1"));
		
		expectedOutput[0] = 4; expectedOutput[1] = 4;
		assertArrayEquals(expectedOutput, board.sanToIndex("e4"));
	}

	@Test
	public void testIndexToSan() {
		fail("Not yet implemented");
	}

	@Test
	public void testWhichPiece() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPositions() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsValidMove() {
		fail("Not yet implemented");
	}

}
