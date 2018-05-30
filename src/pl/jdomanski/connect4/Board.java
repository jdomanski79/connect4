package pl.jdomanski.connect4;

public class Board {
	
	public final static int ROWS  = 7;
	public final static int COLUMNS = 6;
	
	private char[][] board;
	private char lastPlayer;
	
	public Board() {
		this.board = new char[ROWS][COLUMNS];
	}
	public Board (char[][] board) {
		this.board = board;
	}
	
	public char getCell(int row, int column) {
		return board[row][column];
	}
	
	public boolean submitMove(int column) {
		
		if (!isValidMove(column))
			return false;
		
		// finding top of column		
		int i = 0;
		while (board[i][column] != '\0') {
			i++;
		}
		// chosing current player
		char player;
		if (lastPlayer == '\0' || lastPlayer == 'o') {
			player = 'x';
		} else {
			player = 'o';
		}
		
		lastPlayer = player;
		board[i][column] = player;
		return true;
	}
	public boolean isValidMove(int column) {
		if (column < 0 || column >= COLUMNS || board[ROWS-1][column] != '\0') {
			return false;
		} else {
			return true;
		}
			
	}
	
	public boolean isConnected(int column) {
		// find last row
		int row = ROWS-1;
		while (row >= 0 && board[row][column] == '\0') {
			row--;
		}
		// if column is empty return false
		if (row < 0 ) return false;
		
		char marker = board[row][column];
		int count = 0;
		int i = row;
		
		// columns
		//up
		while (i < ROWS && board[i][column] == marker) {
			count++;
			i++;
		}
		//down
		i = row - 1;
		while (i >= 0 && board[i][column] == marker) {
			count++;
			i--;
		}
		if (count >= 4) return true;
		
		count = 0;
		// rows
		// to right
		i = column;
		while(i < COLUMNS && board[row][i] == marker) {
			count++;
			i++;
		}
		//to left
		i = column - 1;
		while (i >= 0 && board[row][i] == marker) {
			count++;
			i--;
		}
		
		if (count >= 4) return true;
		
		// diagonal top to bottom
		i = row;
		int j = column;
		count = 0;
		// to bottom right
		while(i >= 0 && j < COLUMNS && board[i][j] == marker) {
			count++;
			i--;
			j++;
		}
		i = row + 1;
		j = column - 1;
		// to top left
		while (i < ROWS && j >= 0 && board[i][j] == marker) {
			count++;
			i++;
			j--;
		}
		if (count >= 4) return true;
		
		// diagonal bottom to top
		i = row;
		j = column;
		count = 0;
		// to top right
		while(i < ROWS && j < COLUMNS && board[i][j] == marker) {
			count++;
			i++;
			j++;
		}
		i = row - 1;
		j = column - 1;
		// to top left
		while (i >= 0 && j >= 0 && board[i][j] == marker) {
			count++;
			i--;
			j--;
		}
		if (count >= 4) return true;
		
		return false;
	}
	
	public void printBoard() {
		String line = "";
		String symbol;
		for (int i = ROWS-1; i >= 0; i--) {
			line += "|";
			for (int j = 0; j < COLUMNS; j++) {
				if (board[i][j] == '\0') {
					symbol = " ";
				} else {
					symbol = String.valueOf(board[i][j]);
				}
				line += symbol + "|";
			}
			System.out.println(line);
			line = "";
		}
		
		System.out.println("-------------");
		System.out.println(" 1 2 3 4 5 6\n\n");
	}
	
	public static void main(String[] args) {
		Board board = new Board();
		board.submitMove(0);
		board.printBoard();
		
	}
	
}
