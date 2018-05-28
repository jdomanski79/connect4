package pl.jdomanski.connect4;

import java.util.Scanner;

public class HumanPlayer extends Player {
	public static Scanner input = new Scanner(System.in);
	
	public HumanPlayer(String name) {
		super(name);
	}

	@Override
	public int getMove(Board board) {
		String userInput;
		System.out.println("Podaj Twój ruch:");
		userInput = input.nextLine();
		
		while (!userInput.matches("[1-6]") || 
			   !board.isValidMove(Integer.parseInt(userInput) - 1)) {
			System.out.println("Podaj nr kolumny (1-6)");
			userInput = input.nextLine();
		}
		System.out.println("ruch jest poprawny? " + board.isValidMove(Integer.parseInt(userInput)));
		
		return Integer.parseInt(userInput) - 1;
	}
	public static void main(String[] args) {
		Board board = new Board();
		Player player = new HumanPlayer("jarek");
		int userMove;
		System.out.println("Testing HumanPlayer class");
		while(true) {
			board.printBoard();
			userMove = player.getMove(board);
			System.out.println("User move: " + userMove);
			board.submitMove(userMove);
		}
	}
}
