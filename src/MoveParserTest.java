import static org.junit.Assert.*;

import org.junit.Test;


public class MoveParserTest {

	@Test
	public void testIsaChar() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsaDigit() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsWhitesMoveFirst() {
		MoveParser moveparser = new MoveParser();
		
		assertEquals(true, moveparser.isWhitesMoveFirst("1. e4 e6"));
		assertEquals(false, moveparser.isWhitesMoveFirst("1... e4 e6"));
	}

}
