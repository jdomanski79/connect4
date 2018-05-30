package pl.jdomanski.connect4.game;

public class Connect4App {
	public static void main(String[] args) {
		Player human = new HumanPlayer("J");
		Player comp = new ComputerRandomPlayer("Comp");
		Board board = new Board();
		
		int move;
		Player currentPlayer = human;
		board.printBoard();
		
		while (true) {
			move = currentPlayer.getMove(board);
			System.out.println("Gracz " + currentPlayer.name + " wybra� ruch " + move);
			board.submitMove(move);
			board.printBoard();
			if (board.isConnected(move)) {
				System.out.println("Koniec gry!");
			}
			
			currentPlayer = (currentPlayer.equals(human))? comp : human;
			
		}
	}
}
