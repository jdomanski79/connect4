package pl.jdomanski.connect4;

import org.springframework.stereotype.Service;

import pl.jdomanski.connect4.game.Player;
import pl.jdomanski.connect4.game.Board;

@Service
public class GameService {
    private Player player1;
    private Player player2;
    private Board board;
    
    public GameService(){}
    
}
