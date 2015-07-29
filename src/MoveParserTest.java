import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by test on 7/29/2015.
 */
public class MoveParserTest {

    @Test
    public void testIsaDigit() throws Exception {
        MoveParser mv = new MoveParser();
        assertEquals(true, mv.isaDigit('1'));
        assertEquals(false, mv.isaDigit('x'));
    }

    @Test
    public void testGetFinalPosition() throws Exception {
        MoveParser mv = new MoveParser();
        assertEquals("f1", mv.getFinalPosition("Nxf1"));
        assertEquals("f1", mv.getFinalPosition("Naxf1"));
        assertEquals("f1", mv.getFinalPosition("Na3xf1"));
        assertEquals("a1", mv.getFinalPosition("Ra1"));
        assertEquals("f7", mv.getFinalPosition("Ra1f7"));
    }

    @Test
    public void testMatchesWithInput() throws Exception {
        MoveParser mv = new MoveParser();
        assertEquals(true, mv.matchesWithInput("e3", "Ne3"));
        assertEquals(true, mv.matchesWithInput("f1", "Ne3"));
        assertEquals(true, mv.matchesWithInput("d1", "Nxe3"));
        assertEquals(true, mv.matchesWithInput("e3", "Nec3"));
        assertEquals(true, mv.matchesWithInput("f1", "Nfc3"));
        assertEquals(true, mv.matchesWithInput("a7", "Naxe3"));
        assertEquals(false, mv.matchesWithInput("a1", "Ne1xc3"));

    }

    @Test
    public void testIsaValidCapture() throws Exception {

    }

    @Test
    public void testUpdateChessboard() throws Exception {

    }

    
	@Test
	public void testIsWhitesMoveFirst() {
		MoveParser moveparser = new MoveParser();
		
		assertEquals(true, moveparser.isWhitesMoveFirst("1. e4 e6"));
		assertEquals(false, moveparser.isWhitesMoveFirst("1... e4 e6"));
	}

}

