package pl.jdomanski.connect4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {
	
	@Test
	void constructor_OnCreate_ContainsEmptyFields() {
		Board board = new Board();
		
		char cell = board.getCell(6,5);
		
		assertEquals('\0', cell);
	}
	
	
	@Test
	void submitMove_NotEmptyBoard_Works() {
		Board board = new Board();
		
		board.submitMove(0);
		board.submitMove(0);
		board.submitMove(0);
		
		assertEquals(board.getCell(0, 0), 'x');
		assertEquals(board.getCell(1, 0), 'o');
		assertEquals(board.getCell(2, 0), 'x');
	}
	
	@Test
	void submitMove_FullColumn_False() {
		Board board = new Board();
		board.submitMove(0);//x
		board.submitMove(0);//o
		board.submitMove(0);//x
		board.submitMove(0);//o
		board.submitMove(0);//x
		board.submitMove(0);//o
		board.submitMove(0);//x
		board.submitMove(0);//o?

		
		assertEquals(board.getCell(Board.ROWS - 1, 0), 'x');
		assertFalse(board.submitMove(0));
	}
	@Test
	void submitMove_ChangePlayers_true() {
		Board board = new Board();
		
		board.submitMove(0);
		board.submitMove(0);
		
		assertEquals(board.getCell(0, 0), 'x');
		assertEquals(board.getCell(1, 0), 'o');
	}
	
	@Test
	void submitMove_InvalidColumn_False() {
		Board board = new Board();
		
		assertFalse(board.submitMove(Board.COLUMNS));
		assertFalse(board.submitMove(-1));
		
	}
	
	@Test
	void isConnected_EmptyBoard_False() {
		Board board = new Board();
		
		assertFalse(board.isConnected(0));
	}
	
	@Test
	void isConnected_Column_True() {
		char __ = '\0';
		char x = 'x';
		//char o = 'o';
		char[][] boardTemplate= {
				{ x , __, __, __, __, __},
				{ x , __, __, __, __, __},
				{ x , __, __, __, __, __},
				{ x , __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
		};
		Board board = new Board(boardTemplate);
		
		assertTrue(board.isConnected(0), "Column is connected!");
	}
	
	@Test
	void isConnected_Row_True() {
		
		char __ = '\0';
		//char x = 'x';
		char o = 'o';
		char[][] boardTemplate= {
				{ o , o , o , o , __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
		};
		Board board = new Board(boardTemplate);
		
		assertTrue(board.isConnected(3));
	}
	
	@Test
	void isConnected_DiagonalTopToBottom_True() {
		char __ = '\0';
		char x = 'x';
		char o = 'o';
		char[][] boardTemplate= {
				{ o , o , o , x , __, __},
				{ o , o , x , __, __, __},
				{ o , x , __, __, __, __},
				{ x , __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
		};
		
		Board board = new Board(boardTemplate);
		
		
		assertTrue(board.isConnected(0));
	}
	
	@Test
	void isConnected_DiagonalBottomToTop_True() {
		char __ = '\0';
		char x = 'x';
		char o = 'o';
		char[][] boardTemplate= {
				{ x , __, __, __, __, __},
				{ o , x , __, __, __, __},
				{ o , o , x , __, __, __},
				{ o , o , o, x , __, __ },
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
		};
		
		Board board = new Board(boardTemplate);
		
		
		
		assertTrue(board.isConnected(3));
	}
	
	@Test
	void isValidMove() {
		char __ = '\0';
		char x = 'x';
		char o = 'o';
		char[][] boardTemplate= {
				{ x , __, __, __, __, __},
				{ o , __, __, __, __, __},
				{ o , __, __, __, __, __},
				{ o , __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
				{ __, __, __, __, __, __},
		};
		
		Board board = new Board(boardTemplate);
		assertTrue(board.isValidMove(5));
		assertTrue(board.isValidMove(4));
		assertTrue(board.isValidMove(3));
		assertTrue(board.isValidMove(2));
		assertTrue(board.isValidMove(1));
		assertTrue(board.isValidMove(0));
	}
	
	@Test
	void isValidMove_invalidColumn_false() {
		char __ = '\0';
		char x = 'x';
		char o = 'o';
		char[][] boardTemplate= {
				{ x , __, __, __, __, __},
				{ o , __, __, __, __, __},
				{ o , __, __, __, __, __},
				{ o , __, __, __, __, __},
				{ x , __, __, __, __, __},
				{ o , __, __, __, __, __},
				{ __, __, __, __, __, __},
		};
		
		Board board = new Board(boardTemplate);
		board.submitMove(0);
		assertFalse(board.isValidMove(-1));
		assertFalse(board.isValidMove(6));
		assertFalse(board.isValidMove(0));
		
	}

}
