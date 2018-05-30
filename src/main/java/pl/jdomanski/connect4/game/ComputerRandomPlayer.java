package pl.jdomanski.connect4.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerRandomPlayer extends Player {

	public ComputerRandomPlayer(String name) {
		super(name);
	}

	private int randomFromList(List<Integer> list) {
		Random rand = new Random();
		int randomIndex = rand.nextInt(list.size());
		
		return list.get(randomIndex);
	}
	
	
	private List<Integer> getPossibleMoves(Board board) {
		List<Integer> possibleMoves = new ArrayList<>();
		
		for (int i = 0; i < Board.COLUMNS; i++) {
			if (board.getCell(Board.ROWS -1, i) == '\0') {
				possibleMoves.add(i);
			}
		}
		
		return possibleMoves;
	}
	
	@Override
	public int getMove(Board board) {
		return randomFromList(getPossibleMoves(board));
	}

}
