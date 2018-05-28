package pl.jdomanski.connect4;

public abstract class Player {
	String name;
	
	public Player(String name) {
		this.name = name;
	}
	public abstract int getMove(Board board);
}
